package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class DataScreen extends AppCompatActivity {

    Button GoBack;
    TextView ID;
    TextView Name;
    TextView Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_screen);

        init();

        String result = getIntent().getStringExtra("value");


        ID.setText(result.substring(0,2));
        Name.setText(result.substring(3));
        Type.setText(getType(Integer. valueOf(result.substring(2,3))));

        GoBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FileHandling fh = new FileHandling();
                try {
                    fh.openRecordsForWriting();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fh.recordWrite(result.substring(0,2),result.substring(3),result.substring(2,3));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fh.recordClose();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent( DataScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        GoBack = findViewById(R.id.GoBack);
        ID = findViewById(R.id.ID);
        Name = findViewById(R.id.Name);
        Type = findViewById(R.id.Type);
    }
    private String getType(int x){
        if(x == 1){
            return "Best";
        }else if(x == 2){
            return "Average";
        }else{
            return "Worst";
        }
    }
}
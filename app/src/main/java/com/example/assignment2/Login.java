package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login  extends AppCompatActivity {

    Button btnSubmit;
    TextView etName;
    TextView etMarks;
    TextView etid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String EtMarks = etMarks.getText().toString();
                String EtName = etName.getText().toString();
                String Etid = etid.getText().toString();

                if(Etid.isEmpty() || Etid.length() != 2 || EtName.isEmpty() || EtMarks.isEmpty()){
                    Toast.makeText(Login .this, "Fill All Inputs", Toast.LENGTH_SHORT).show();
                }else {


                    Float n = Float.parseFloat(EtMarks);
                    if(n>=80){
                        EtMarks = "1";
                    }else if(n>=60){
                        EtMarks = "2";
                    }else{
                        EtMarks = "3";
                    }
                    Intent intent = new Intent(Login.this, DataScreen.class);
                    intent.putExtra("value" , Etid + EtMarks + EtName );
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init(){
        btnSubmit  = findViewById(R.id.btnSubmit);
        etName  = findViewById(R.id.etName);
        etMarks    = findViewById(R.id.etMarks);
        etid = findViewById(R.id.etid);
    }
}
package com.example.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileHandling {
    final String RECORD = "BAW.txt";

    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;


    public FileHandling(){
    }

    void openRecordsForWriting() throws IOException {
        fw = new FileWriter(RECORD,true);
        bw = new BufferedWriter(fw);
    }

    void recordClose() throws IOException {
        bw.close();
        fw.close();
    }
    void recordWrite(String id, String name, String type) throws IOException{
        bw.write("\n" + id + "		" + name + "		"+type);
    }
}
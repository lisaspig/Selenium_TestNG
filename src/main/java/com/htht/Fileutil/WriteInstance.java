package com.htht.Fileutil;

import com.htht.General.FileCheck;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInstance {
    private static WriteInstance ourInstance = new WriteInstance();

    public static WriteInstance getInstance() {
        return ourInstance;
    }

    private WriteInstance() {

    }

    public void fileWrite(String filepath,String str){
        File file = FileCheck.creatFile(filepath);
        if(file.exists()){
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

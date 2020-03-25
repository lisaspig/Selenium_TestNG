package com.htht.General;

import java.io.File;
import java.io.IOException;

public class FileCheck {

    public static void makeDir(String dirPath){
        File file = new File(dirPath);
        if(!file.exists()||!file.isDirectory()){
            file.mkdir();
        }
    }

    public static void creatFile(String filepath){
        File file = new File(filepath);
        if(!file.exists()||!file.isFile()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

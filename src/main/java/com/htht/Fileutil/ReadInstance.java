package com.htht.Fileutil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ReadInstance {
    private final static ReadInstance READSINGLETON = new ReadInstance();
    private ReadInstance() {
    }
    public static ReadInstance getInstance() {
        return READSINGLETON;
    }
    public  String getjsonfile(String filepath) {
        String fileread =null;
        try {
            fileread = FileUtils.readFileToString(new File(filepath),"UTF-8");
        } catch (IOException e) {

            e.printStackTrace();
        }
        return fileread ;
    }
}

package com.GetJson;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
public class ReadSingleton {
    private final static ReadSingleton readsingleton = new ReadSingleton();

    private  ReadSingleton() {

    }

    public static ReadSingleton getReadSingleton() {

        return readsingleton;
    }


    public static String getjsonfile(String filepath) {

        String fileread =null;
        try {
            fileread = FileUtils.readFileToString(new File(filepath),"UTF-8");
        } catch (IOException e) {

            e.printStackTrace();
        }
        return fileread ;
    }

}

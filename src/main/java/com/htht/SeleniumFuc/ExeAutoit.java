package com.htht.SeleniumFuc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExeAutoit {
    private static String upexepath = "AutoIT/upfile.exe";
    private static String downexepath = "AutoIT/downfile.exe";
    public static void  upFile(String filepath){
        runExe(upexepath,filepath);
    }

    public static void  downFile(String filepath){
        runExe(downexepath,filepath);
    }

    private static void runExe(String exepath,String parameter){
        try {
            String[] cmd = new String[] {exepath, parameter};
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String l;
            while((l = r.readLine()) != null) {
                System.out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

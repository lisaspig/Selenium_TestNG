package com.Fileutil;

import java.io.*;
import java.util.Properties;

public class GetProperties {

    private static String reportpath;
    private static String dirverpath;
    private static String logpath;
    private static String imagepath;
    private static String isremot;

    public static String getReportpath() {
        return reportpath;
    }

    public static String getDirverpath() {
        return dirverpath;
    }

    public static String getLogpath() {
        return logpath;
    }

    public static String getImagepath() {
        return imagepath;
    }

    public static String getIsremot() {
        return isremot;
    }

    public static void paserProperties(){
        String propertypath = "conf/conf.properties";
        File file = new File(propertypath);

        Properties pro = new Properties();
        if(file.exists()){
            try {
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                pro.load(in);
                in.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            reportpath = pro.getProperty("reportpath");
            dirverpath=pro.getProperty(" dirverpath");
            logpath=pro.getProperty(" logpath");
            imagepath=pro.getProperty("imagepath");
            isremot=pro.getProperty(" isremot");

        }else {
            try {
                file.createNewFile();
                FileOutputStream oFile = new FileOutputStream(propertypath, true);
                pro.setProperty("reportpath","report");
                pro.setProperty("logpath","logs");
                pro.setProperty("dirverpath","webdriver");
                pro.setProperty("imagepath","images");
                pro.setProperty("isremot","true");
                pro.store(oFile,"新增属性值");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

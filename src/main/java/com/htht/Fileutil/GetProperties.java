package com.htht.Fileutil;

import java.io.*;
import java.util.Properties;

public class GetProperties extends PropertiesInit{


    public static void paserProperties(){
        String propertypath = "conf/conf.properties";
        File file = new File(propertypath);
        Properties pro = new Properties();
        if(file.exists()){
            getProperty(pro,file);
        }else {
            setProperty(pro,file,propertypath);
            getProperty(pro,file);
        }

    }

    private static void getProperty( Properties pro,File file){
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            pro.load(in);
            in.close();
            PropertiesInit.setReportpath(pro.getProperty("reportpath"));
            PropertiesInit.setDirverpath(pro.getProperty("dirverpath"));
            PropertiesInit.setLogpath(pro.getProperty("logpath"));
            PropertiesInit.setImagepath(pro.getProperty("imagepath"));
            PropertiesInit.setIsremot(pro.getProperty("isremot"));
            PropertiesInit.setRetrycont(pro.getProperty("retrycont"));
            PropertiesInit.setRetrycont(pro.getProperty("remothub")+"/wd/hub");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void setProperty(Properties pro,File file,String propertypath){
        try {
            file.createNewFile();
            FileOutputStream oFile = new FileOutputStream(propertypath, true);
            pro.setProperty("reportpath","report");
            pro.setProperty("logpath","logs");
            pro.setProperty("dirverpath","webdriver");
            pro.setProperty("imagepath","images");
            pro.setProperty("isremot","true");
            pro.setProperty("retrycont","3");
            pro.store(oFile,"新增属性值");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        GetProperties.paserProperties();
        System.out.println(PropertiesInit.getRetrycont());
    }
}

package com.htht.SeleniumFuc;

import com.htht.Fileutil.PropertiesInit;
import com.htht.General.FileCheck;
import com.htht.General.TimeFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenImage {


    private  WebDriver driver;

    public  void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void screen(String filename)throws IOException, InterruptedException {
        if (this.driver!=null) {
            String imagepath = PropertiesInit.getImagepath();
            System.out.println("path+++++++++++++++++++++++"+imagepath);
            FileCheck.creatFile(imagepath);
            String Datatime = TimeFormat.getTimeStr( "yyyy-MM-dd-HH-mm");
            File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ssfile, new File(imagepath +"/"+ filename + Datatime + ".png"));
        }else {
            System.out.println("driver=null");
        }
    }
}

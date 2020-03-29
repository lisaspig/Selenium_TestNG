package com.htht.SeleniumFuc;

import com.htht.Fileutil.PropertiesInit;
import com.htht.General.FileCheck;
import com.htht.General.TimeFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

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
            String DayData =TimeFormat.getTimeStr("yyyyMMdd");
            String SecondData =TimeFormat.getTimeStr("HHmmss");
            String imagepath = PropertiesInit.getImagepath()+"/"+DayData;
            FileCheck.makeDir(imagepath);
            File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File resultfile = new File(imagepath +"/"+ filename + SecondData + ".png");
            FileUtils.copyFile(ssfile,resultfile);
            Reporter.log("失败截图:"+"<a href="+resultfile.getCanonicalFile()+"><image src="+resultfile.getCanonicalFile()+"></a>");
        }else {
            System.out.println("driver=null");
        }
    }
}

package com.htht.SeleniumFuc;

import com.htht.Fileutil.PropertiesInit;
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
            File file = new File(imagepath);
            if (!file.exists()||!file.isDirectory()) {
                file.mkdir();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");//设置时间格式
            String Datatime = df.format(new Date());//获取当前时间
            File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ssfile, new File(imagepath +"/"+ filename + Datatime + ".png"));
        }else {
            System.out.println("driver=null");
        }
    }
}

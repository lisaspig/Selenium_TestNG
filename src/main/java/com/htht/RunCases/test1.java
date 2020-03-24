package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.ScreenImage;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class test1 extends DriverBase {

    WebDriver driver1;
    @Test(testName = "getDriver",priority =0)
    public void setUP(WebDriver driver){
        this.driver1=driver;
    }

    @Test(testName = "test2",groups = "test2")
    public void mytest(){
        if(this.driver1==null){
            System.out.println("无法获取driver");
            driver1=null;
        }else {

            driver1.get("http://www.baidu.com");
            System.out.println("test1.title="+driver1.getTitle());
            Assert.assertEquals(SeleniumException.titleContains(this.driver1,"百度一下","3"),true);
            try {
                Thread.sleep(3000);
                ScreenImage screenImage = new ScreenImage();
                screenImage.setDriver(this.driver1);
                screenImage.screen("test123");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

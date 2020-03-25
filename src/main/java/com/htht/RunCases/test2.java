package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.ScreenImage;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class test2 extends DriverBase{

    WebDriver driver;
    @Test(testName = "test2_driver",groups = "test2",priority = 0)
    public void setup(){
        this.driver=super.getDriver();
        System.out.println(this.driver+"this.driver1");
    }

    @Test(testName = "test2",groups = "test2",dependsOnMethods = "setup")
    public void myTest(){
        if(this.driver==null){
            System.out.println("无法获取driver");
            this.driver=null;
        }else {
            this.driver.get("http://www.baidu.com");
            System.out.println("test2.title="+this.driver.getTitle());
            Assert.assertEquals(SeleniumException.titleContains(this.driver,"百度一下.test2","3"),true);
            try {
                Thread.sleep(3000);
                ScreenImage screenImage = new ScreenImage();
                screenImage.setDriver(this.driver);
                screenImage.screen("test234");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

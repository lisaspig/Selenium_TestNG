package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.Listener.ScreenListener;
import com.htht.SeleniumFuc.ScreenImage;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ScreenListener.class})
public class test1 extends DriverBase  {

    WebDriver driver1;

    @Test(testName = "test1_driver",groups = "test1",priority = 0)
    public void setup(){
        this.driver1=super.getDriver();
        System.out.println(this.driver1+"this.driver1");
    }

    @Test(testName = "test1",groups = "test1",dependsOnMethods = "setup")
    public void myTest(){
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

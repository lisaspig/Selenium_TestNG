package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.ScreenImage;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class test2 extends DriverBase {

    WebDriver driver;
    @Test(testName = "getDriver",priority =0)
    public void setUP(){
        this.driver=super.getDriver();
    }
    @Test(testName = "test1",groups = "test1",priority =0)
    public void myTest(ITestContext ctx){
        if(this.driver==null){
            System.out.println("无法获取driver");
            this.driver=null;
        }else {

            this.driver.get("http://www.baidu.com");
            System.out.println("test2.title="+this.driver.getTitle());
            Assert.assertEquals(SeleniumException.titleContains(this.driver,"百度一下","3"),true);
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

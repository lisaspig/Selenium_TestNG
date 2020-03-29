package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 extends DriverBase {
    WebDriver driver;
    @Test
    public void setup(){
        this.driver = super.getDriver();
    }

    @Test(testName = "test1",groups = "test1")
    public void myTest1(){
        System.out.println("test1");
        SeleniumAction.openPage("http://www.baidu.com");
        Assert.assertEquals(SeleniumException.titleContains("百度一下1","3"),true);
    }
}

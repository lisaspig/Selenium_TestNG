package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class test1 extends DriverBase {
    WebDriver driver;

    @Test(testName = "test0.1")
    public void setup(){
        this.driver = super.getDriver();
    }

    @Test(testName = "test1",groups = "test1",dependsOnMethods = "setup")
    public void myTest1(){
        System.out.println("test1.driver="+this.driver);
        SeleniumAction.openPage(this.driver,"http://10.1.1.78:8080/");
        Assert.assertEquals(SeleniumException.titleContains("百度一下1","3",this.driver),true);
    }
}

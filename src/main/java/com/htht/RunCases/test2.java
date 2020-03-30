package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class test2 extends DriverBase{

    WebDriver driver;
     @Test(testName = "test0.2")
    public void setup(){
         System.out.println("test2.driver="+this.driver);
        this.driver = super.getDriver();
    }

    @Test(testName = "test2",groups = "test2",dependsOnMethods = "setup")
    public void myTest1(){
        System.out.println("test2.driver="+this.driver);
        SeleniumAction.openPage(this.driver,"http://10.1.1.78:8080");
        Assert.assertEquals(SeleniumException.titleContains("工作台","3",this.driver),true);
    }

}

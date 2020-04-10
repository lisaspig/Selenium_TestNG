package com.htht.RunCases;

import com.htht.CasesBase.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.SeleniumFuc.SeleniumExpected;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        SeleniumAction.openPage(this.driver,"http://10.1.1.107:5555/grid/console");
        Assert.assertEquals(SeleniumExpected.titleContains("百度一下1",this.driver),true);
    }
}

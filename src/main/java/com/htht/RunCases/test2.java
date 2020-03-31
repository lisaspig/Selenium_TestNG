package com.htht.RunCases;

import com.htht.CasesBase.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.CasesBase.AssertBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test2 extends DriverBase{

    WebDriver driver;
     @Test(testName = "test0.2")
    public void setup(){
        this.driver = super.getDriver();
    }

    @Test(testName = "test2",groups = "test2",dependsOnMethods = "setup")
    public void myTest1(){
        System.out.println("test2.driver="+this.driver);
        SeleniumAction.openPage(this.driver,"http://10.1.1.107:5555/grid/console");
        Assert.assertEquals(AssertBase.titleContains("工作台","3",this.driver),true);
    }

}

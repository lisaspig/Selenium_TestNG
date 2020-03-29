package com.htht.RunCases;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.TestAsert.SeleniumException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test2 extends DriverBase{
    @Test(testName = "test2",groups = "test2")
    public void myTest2(){
        System.out.println("test2");
        SeleniumAction.openPage("http://www.baidu.com");
        Assert.assertEquals(SeleniumException.titleContains("百度一下","3"),true);
    }

}

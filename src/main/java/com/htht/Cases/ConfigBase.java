package com.htht.Cases;

import com.htht.Fileutil.GetProperties;
import org.testng.annotations.BeforeSuite;

public class ConfigBase {
    @BeforeSuite
    public static void beforSuit(){
        System.out.println("testSuit+++++++++++++++++++++++++++++++++befor");
        GetProperties.paserProperties();
    }
}

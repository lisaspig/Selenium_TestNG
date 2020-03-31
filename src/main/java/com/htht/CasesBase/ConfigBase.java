package com.htht.CasesBase;

import com.htht.Fileutil.GetProperties;
import org.testng.annotations.BeforeSuite;

public class ConfigBase {
    @BeforeSuite
    public static void beforSuit(){
        GetProperties.paserProperties();
    }
}

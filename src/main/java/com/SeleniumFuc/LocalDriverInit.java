package com.SeleniumFuc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LocalDriverInit {
    private String browser;
    private String driverpath;

    @BeforeTest
    public String getBrowser() {
        return browser;
    }
    @BeforeTest
    @Parameters({"browser"})
    public void setBrowser(String browser) {
        this.browser = browser;
    }
    @BeforeTest
    public String getDriverpath() {
        return driverpath;
    }
    @BeforeTest
    @Parameters({"driverpath"})
    public void setDriverpath(String driverpath) {
        this.driverpath = driverpath;
    }
}

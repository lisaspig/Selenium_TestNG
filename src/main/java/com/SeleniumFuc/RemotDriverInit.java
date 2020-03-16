package com.SeleniumFuc;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class RemotDriverInit {
    private  String browser;
    private String  remoturl;
    private String  platform;
    private String isremot;

    @BeforeTest
    public String getIsremot() {
        return isremot;
    }
    @BeforeTest
    @Parameters({"isremot"})
    public void setIsremot(String isremot) {
        this.isremot = isremot;
    }



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
    public String getRemoturl() {
        return remoturl;
    }
    @BeforeTest
    @Parameters({"remoturl"})
    public void setRemoturl(String remoturl) {
        this.remoturl = remoturl;
    }
    @BeforeTest
    public String getPlatform() {
        return platform;
    }
    @BeforeTest
    @Parameters({"platform"})
    public void setPlatform(String platform) {
        this.platform = platform;
    }
}

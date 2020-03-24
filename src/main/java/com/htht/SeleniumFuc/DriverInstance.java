package com.htht.SeleniumFuc;

import org.openqa.selenium.WebDriver;


public class DriverInstance {


    private static DriverInstance ourInstance = new DriverInstance();

    public static DriverInstance getInstance() {
        return ourInstance;
    }

    private DriverInstance() {

    }

    public WebDriver getRemotDriver(String remoturl,String platform,String browser){
        RemotDriverInit remotDriverInit = new RemotDriverInit(remoturl,platform,browser);
        return remotDriverInit.getWebdriver();
    }

    public WebDriver getLocalDriver(String browser,String driverpath){
        LocalDriverInit localDriverInit = new LocalDriverInit(browser,driverpath);
        return localDriverInit.getWebdriver();
    }
}

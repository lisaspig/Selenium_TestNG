package com.SeleniumFuc;

import org.openqa.selenium.WebDriver;

public class DriverInstance {

    private static DriverInstance ourInstance = new DriverInstance();

    public static DriverInstance getInstance() {
        return ourInstance;
    }

    private DriverInstance() {

    }
    public WebDriver getDriver(){
        RemotDriverInit remotDriverInit = new RemotDriverInit();
         String browser = remotDriverInit.getBrowser();
        String  remoturl=remotDriverInit.getRemoturl();
        String  platform=remotDriverInit.getRemoturl();
        String isremot = remotDriverInit.getIsremot();
        if (!isremot.equals("true")){
            return getLocalDriver();}
        else{
            return RemotDriver.getWebdriver(browser,remoturl,platform);
        }

    }

    public WebDriver getLocalDriver(){
       LocalDriverInit localDriverInit = new LocalDriverInit();
        String browser = localDriverInit.getBrowser();
        String driverpath=localDriverInit.getDriverpath();
        return  LocalDriver.getWebdriver(browser,driverpath);
    }

}

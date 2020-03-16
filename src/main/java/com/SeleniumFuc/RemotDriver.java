package com.SeleniumFuc;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemotDriver {

    public static WebDriver getWebdriver(String _browser,String _remoturl,String _platform){
        URL remoturl;
        WebDriver driver=null;
        DesiredCapabilities capabilities =null;
        if(_browser.equals("firefox")){
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("firefox");
        }else if(_browser.equals("edge")){
            capabilities = DesiredCapabilities.edge();
            capabilities.setBrowserName("edge");
        }else{
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
        }

        if(_platform.equals("windows")){
            capabilities.setPlatform(Platform.WINDOWS);
        }else if(_platform.equals("win10")){
            capabilities.setPlatform(Platform.WIN10);
        }else if(_platform.equals("any")){
            capabilities.setPlatform(Platform.ANY);
        }else {
            capabilities.setPlatform(Platform.LINUX);
        }
            capabilities.setJavascriptEnabled(true);
        try {
            remoturl = new URL(_remoturl);
            driver = new RemoteWebDriver( remoturl,capabilities);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }


}

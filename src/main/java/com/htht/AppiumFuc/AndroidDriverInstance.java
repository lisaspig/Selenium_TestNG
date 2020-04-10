package com.htht.AppiumFuc;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.PaserJsonfile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverInstance {
    private static AndroidDriverInstance ourInstance = new AndroidDriverInstance();

    public static AndroidDriverInstance getInstance() {
        return ourInstance;
    }

    private AndroidDriverInstance() {

    }
    public AndroidDriver<WebElement> getDriver(String appiumconf){
        JSONObject jsonObject = PaserJsonfile.getJobject(appiumconf);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for(String key : jsonObject.keySet()){
            String value = jsonObject.get(key).toString();
            if(value!=null){
                capabilities.setCapability(key,value);
            }
        }
        AndroidDriver<WebElement> driver=null;
        try {
            driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

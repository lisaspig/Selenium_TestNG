package com.htht.Cases;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestBase {

    WebDriver driver;
    HashMap<String,HashMap<String,String>>hashMap;
    public void openUrl(String url){
        driver.get(url);
    }
    public void login(){
        hashMap.get("用户名").get("login");
    }
}

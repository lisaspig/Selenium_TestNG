package com.htht.CasesBase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenPageBase {
    public static void openPageByLogin(String url,String titleAssert,WebDriver driver,String username,String password ,String asserttext,String action ){
        driver.get(url);
        if(!driver.getTitle().equals(titleAssert)){
            CookieBase.addCookieFromJson("zentaosid",driver);
            driver.get(url);
            if(!driver.getTitle().equals(titleAssert)){
                new LoginBase(driver).login(username,password,asserttext,action);
                System.out.println("登录一次");
                CookieBase.setCookieJson(driver);
                CookieBase.addAllCookieFromJson(driver);
                System.out.println("add ALL ccokie"+driver.manage().getCookies());
                driver.get(url);
            }
        }
    }

    public static void openPageByLogin(String url,WebElement assertelement,WebDriver driver, String username, String password , String asserttext, String action ){
        CookieBase.addAllCookieFromJson(driver);
        driver.get(url);
        if(assertelement==null){
            new LoginBase(driver).login(username,password,asserttext,action);
            CookieBase.setCookieJson(driver);
            CookieBase.addAllCookieFromJson(driver);
            driver.get(url);
        }
    }
}

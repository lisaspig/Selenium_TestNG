package com.htht.CasesBase;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.GetCases;
import com.htht.Fileutil.PaserJsonfile;
import com.htht.SeleniumFuc.LocatElement;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.SeleniumFuc.SeleniumExpected;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginBase {

    String url;
    LocatElement logElment;
    String pageAssert;
    WebDriver driver;

    public LoginBase(WebDriver driver) {
        this.driver = driver;
    }

    public void setElment() {
        JSONObject elementobject= PaserJsonfile.getJobject("testData/caseElement/test_Ele.json");
        this.url = elementobject.get("url").toString();
        this.pageAssert=elementobject.get("pageAssert").toString();
        logElment= new LocatElement(this.driver, GetCases.getEle(elementobject,"登录页面"));
    }


    public void  login(String username,String password ,String asserttext,String action ){
        setElment();
        driver.get(url);
        SeleniumExpected.titleIs(pageAssert, driver);
        SeleniumAction.sendKeys(logElment.getElement("用户名"),username);
        SeleniumAction.sendKeys(logElment.getElement("密码"),password);
        SeleniumAction.clickElment(logElment.getElement("登录"));
        try {
            Alert alert = SeleniumAction.swichAlter("3",driver);
            SeleniumExpected.alterIsPasser(asserttext,alert);
            SeleniumAction.clickAlert(action,alert);
        } catch (Exception e) {
            SeleniumExpected.titleIs(asserttext, driver);
        }
    }
}

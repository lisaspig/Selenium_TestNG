package com.htht.Cases;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.GetCases;
import com.htht.Fileutil.PaserJsonfile;
import com.htht.Fileutil.ReadInstance;
import com.htht.SeleniumFuc.LocatElement;
import com.htht.SeleniumFuc.SeleniumAction;
import org.openqa.selenium.WebDriver;

public class LoginBase extends DriverBase implements ITestCase{


    WebDriver driver;
    JSONObject object;
    LocatElement logElment;

    public void openLoginPage(){
        String url =object.getJSONObject("url").toString();
        driver.get(url);
    }


    @Override
    public void setDriver() {
        object= PaserJsonfile.getJobject(ReadInstance.getInstance().getjsonfile("testData/caseElement/test_Ele.json"));
        this.driver = super.getDriver();
    }

    @Override
    public void setElment() {
        logElment= new LocatElement(this.driver,GetCases.getEle(object,"登录"));

    }

    @Override
    public void setTestData() {

    }

    public void sendUsername(String username){
       SeleniumAction.sendKeys( logElment.getElement("用户名"),username);
    }

    public void sendPassword(String password){
        SeleniumAction.sendKeys( logElment.getElement("密码"),password);
    }

    public void clickLogin(){
        SeleniumAction.clickElment( logElment.getElement("登录"));
    }
}

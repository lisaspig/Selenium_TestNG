package com.htht.TestCase;

import com.alibaba.fastjson.JSONObject;
import com.htht.CasesBase.AssertBase;
import com.htht.CasesBase.DriverBase;
import com.htht.Fileutil.GetCases;
import com.htht.Fileutil.PaserJsonfile;
import com.htht.SeleniumFuc.LocatElement;
import com.htht.SeleniumFuc.SeleniumAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends DriverBase implements ITestCase {

    WebDriver driver;
    String url;
    LocatElement logElment;
    JSONObject dataobject;

    @Override
    @BeforeClass
    public void setDriver() {
        this.driver = super.getDriver();
    }

    @Override
    @BeforeClass
    public void setElment() {
        JSONObject elementobject= PaserJsonfile.getJobject("testData/caseElement/test_Ele.json");
        this.url = elementobject.get("url").toString();
        logElment= new LocatElement(this.driver,GetCases.getEle(elementobject,"登录"));
    }

    @Override
    @BeforeClass
    public void setTestData() {
      this.dataobject= PaserJsonfile.getJobject("testData/caseData/test_Dat.json");
    }

    public void openLoginPage(){
       this.driver.get(this.url);

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

    public void assertLogin(String asserttext,String action){
        Alert alert = SeleniumAction.swichAlter("3",this.driver);
        AssertBase.alterIsPasser(asserttext,alert);
        SeleniumAction.clickAlert(action,alert);
    }
    @Test(dataProvider = "loginpara")
    public void login(String username,String password ,String asserttext,String action ){
        openLoginPage();
        sendUsername(username);
        sendPassword(password);
        clickLogin();
        try {
            assertLogin(asserttext,action);
        } catch (Exception e) {
            AssertBase.titleIs(asserttext,"3", this.driver);
        }
    }

    @DataProvider(name = "loginpara")
    public Object[][]loginDataPriade(){
        return  GetCases.getData(dataobject,"登录_caseData");
    }

}

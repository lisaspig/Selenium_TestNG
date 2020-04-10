package com.htht.TestCase;

import com.alibaba.fastjson.JSONObject;
import com.htht.CasesBase.DriverBase;
import com.htht.CasesBase.LoginBase;
import com.htht.CasesBase.OpenPageBase;
import com.htht.Fileutil.GetCases;
import com.htht.Fileutil.PaserJsonfile;
import com.htht.SeleniumFuc.LocatElement;
import com.htht.SeleniumFuc.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyPageTest extends DriverBase implements ITestCase {

    WebDriver driver;
    String url;
    LocatElement logElment;
    JSONObject dataobject;
    String pageAssert;
    @Override
    @BeforeClass
    public void setDriver() {
        this.driver = super.getDriver();
    }

    @Override
    @BeforeClass
    public void setElment() {
        JSONObject elementobject= PaserJsonfile.getJobject("testData/caseElement/my_Ele.json");
        this.url = elementobject.get("url").toString();
        this.pageAssert=elementobject.get("pageAssert").toString();
        logElment= new LocatElement(this.driver, GetCases.getEle(elementobject,"最新动态"));
    }

    @Override
    @BeforeClass
    public void setTestData() {
        this.dataobject= PaserJsonfile.getJobject("testData/caseData/test_Dat.json");

    }
    @Test(testName = "gomore",dataProvider = "login_my",description = "查看更多动态信息")
    public void runTest(String username,String password ,String asserttext,String action){
         new LoginBase(driver).login(username, password,asserttext,action);
        SeleniumAction.clickElment(logElment.getElement("更多动态"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "login_my")
    public Object[][]loginonceDataPriade(){
        return  GetCases.getData(dataobject,"登录_onceData");
    }
}

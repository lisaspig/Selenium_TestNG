package com.htht.TestCase;

import com.alibaba.fastjson.JSONObject;
import com.htht.CasesBase.DriverBase;
import com.htht.CasesBase.LoginBase;
import com.htht.Fileutil.GetCases;
import com.htht.Fileutil.PaserJsonfile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends DriverBase implements ITestCase {

    WebDriver driver;
    JSONObject dataobject;

    @Override
    @BeforeClass
    public void setDriver() {
        this.driver = super.getDriver();
    }

    @Override
    public void setElment() {

    }

    @Override
    @BeforeClass
    public void setTestData() {
        this.dataobject= PaserJsonfile.getJobject("testData/caseData/test_Dat.json");
    }


    @Test(testName = "login",dataProvider = "login_para",description = "登录")
    public void login(String username,String password ,String asserttext,String action){
        new LoginBase(this.driver).login(username, password,asserttext,action);

    }

    @DataProvider(name = "login_para")
    public Object[][]loginDataPriade(){
        return  GetCases.getData(dataobject,"登录_caseData");
    }


}


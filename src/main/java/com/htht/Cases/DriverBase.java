package com.htht.Cases;

import com.htht.Fileutil.PropertiesInit;
import com.htht.SeleniumFuc.DriverInstance;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.TestAsert.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DriverBase {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    @Parameters({"remoturl","platform","browser"})
    public void creatDriver(String remoturl,String platform,String browser) {
        String isremot = PropertiesInit.getIsremot();
//        remoturl = PropertiesInit.getRemothub()+"/wd/hub";
        if (isremot.equals("true")&&isremot!=null){
            this.driver=DriverInstance.getInstance().getRemotDriver(remoturl,platform,browser);
        }else if(isremot.equals("false")||isremot==null){
            String driverpath =PropertiesInit.getDirverpath();
            this.driver=DriverInstance.getInstance().getLocalDriver(browser,driverpath);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDownTest(ITestResult rt){
        System.out.println(rt.getTestName()+"测试执行完成");
        this.driver.quit();
    }

}

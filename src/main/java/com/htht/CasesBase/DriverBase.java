package com.htht.CasesBase;

import com.htht.Fileutil.PropertiesInit;
import com.htht.SeleniumFuc.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
    @Parameters({"browser"})
    public void creatDriver(String browser) {
        String isremot = PropertiesInit.getIsremot();
//        remoturl = PropertiesInit.getRemothub()+"/wd/hub";
        if (isremot.equals("true")&&isremot!=null){
            String remoturl = PropertiesInit.getRemothub()+"/wd/hub";
            String platform = PropertiesInit.getPlatform();
            this.driver=DriverInstance.getInstance().getRemotDriver(remoturl,platform,browser);
        }else if(isremot.equals("false")||isremot==null){
            String driverpath =PropertiesInit.getDirverpath();
            this.driver=DriverInstance.getInstance().getLocalDriver(browser,driverpath);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownTest(){
        System.out.println("测试执行完成");
        this.driver.quit();
    }

}

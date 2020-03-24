package com.htht.Cases;

import com.htht.Fileutil.PropertiesInit;
import com.htht.SeleniumFuc.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class DriverBase {
    private WebDriver driver;
    @BeforeTest()
    @Parameters({"remoturl","platform","browser"})
    public WebDriver setDriver(String remoturl,String platform,String browser) {
        System.out.println("remoturl="+remoturl);
        System.out.println("platform="+platform);
        System.out.println("browser="+browser);
        String isremot = PropertiesInit.getIsremot();
        if (isremot.equals("true")&&isremot!=null){
            setDriver(DriverInstance.getInstance().getRemotDriver(remoturl,platform,browser));
        }else if(isremot.equals("false")||isremot==null){
            String driverpath =PropertiesInit.getDirverpath();
            setDriver(DriverInstance.getInstance().getLocalDriver(browser,driverpath));
        }
//        ctx.setAttribute("webDriver",this.driver);
        return this.driver;
    }
    @BeforeTest()
    private void counText(ITestContext ctx){
        ctx.setAttribute("webdriver",this.driver);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
//        ctx.setAttribute("webDriver",this.driver);
        System.out.println("huo qu driver");
        System.out.println(this.driver);

        return this.driver;
    }
    @AfterTest
    public void tearDownTest(){
        this.driver.quit();
    }

}

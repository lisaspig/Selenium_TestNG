package com.htht.Cases;

import com.htht.Fileutil.PropertiesInit;
import com.htht.SeleniumFuc.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverBase {
    private WebDriver driver;

    @BeforeClass
    @Parameters({"remoturl","platform","browser"})
    public void creatDriver(String remoturl,String platform,String browser) {
        System.out.println("remoturl="+remoturl);
        System.out.println("platform="+platform);
        System.out.println("browser="+browser);
        String isremot = PropertiesInit.getIsremot();
        if (isremot.equals("true")&&isremot!=null){
            this.driver=DriverInstance.getInstance().getRemotDriver(remoturl,platform,browser);
        }else if(isremot.equals("false")||isremot==null){
            String driverpath =PropertiesInit.getDirverpath();
            this.driver=DriverInstance.getInstance().getLocalDriver(browser,driverpath);
        }
//        ctx.setAttribute("webDriver",this.driver);
    }
//    @BeforeTest()
//    private void counText(ITestContext ctx){
//        ctx.setAttribute("webdriver",this.driver);
//    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
//    @Test()
    public WebDriver getDriver() {
//      ctx.setAttribute("webDriver",this.driver);
        System.out.println("huo qu driver");
        System.out.println(this.driver);
        return this.driver;
    }
    @AfterClass
    public void tearDownTest(){
        System.out.println("测试完成");
        this.driver.quit();
    }

}

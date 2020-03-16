package com.Cases;

import com.SeleniumFuc.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverBase {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void  setupTest(){
        this.driver = DriverInstance.getInstance().getDriver();
    }

    @AfterTest
    public void tearDownTest(){
        this.driver.quit();
        this.driver.close();
    }
}

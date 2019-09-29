package com.SeleniumFuc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class getDriver {

    String driverpath;


    public getDriver(String _driverpath) {
        this.driverpath = _driverpath;

    }

    public WebDriver foxdriver() {

        System.setProperty("webdriver.gecko.driver",driverpath);
        System.out.println(System.getProperty("webdriver.gecko.driver"));
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver chdriver() {

        System.setProperty("webdriver.chorme.driver",driverpath);
        System.out.println(System.getProperty("webdriver.chorme.driver"));
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}

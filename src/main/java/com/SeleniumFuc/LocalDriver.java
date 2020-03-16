package com.SeleniumFuc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class LocalDriver {

    public enum browser{
        FIREFOX, CHROME,IE,EDGE
    }
    public static WebDriver getWebdriver(String _browser,String _driverpath){

        WebDriver driver = null;
        browser type = browser.valueOf(_browser);
        switch (type){
            case IE:
                System.setProperty("webdriver.InternetExplorer.driver",_driverpath);
                driver=new InternetExplorerDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver",_driverpath);
                driver=new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.grocke.driver",_driverpath);
                driver=new FirefoxDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver",_driverpath);
                driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

}

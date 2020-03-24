package com.htht.SeleniumFuc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class LocalDriverInit {
    private String browser;
    private String driverpath;
    public LocalDriverInit(String browser, String driverpath) {
        this.browser = browser;
        this.driverpath = driverpath;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDriverpath() {
        return driverpath;
    }

    public void setDriverpath(String driverpath) {
        this.driverpath = driverpath;
    }

        public WebDriver getWebdriver(){
        WebDriver driver = null;
        File file = new File(this.driverpath);
            System.out.println("driverpath="+driverpath);
        if(file.exists()){
            if(this.browser.equals("firefox")){
                System.out.println("firefox is browser");
                System.setProperty("webdriver.grocke.driver",this.driverpath+"/geckodriver.exe");
                driver=new FirefoxDriver();
            }else if(this.browser.equals("ie")){
                System.setProperty("webdriver.InternetExplorer.driver",this.driverpath+"/internetexplorer.exe");
                driver=new InternetExplorerDriver();
            }else if(this.browser.equals("edge")){
                System.setProperty("webdriver.edge.driver",this.driverpath+"/edge.exe");
                driver=new EdgeDriver();
            }else{
                System.out.println("chorme is browser");
                System.setProperty("webdriver.chrome.driver",this.driverpath+"/chromedriver.exe");
                driver=new ChromeDriver();
            }
        }else {
            File file1 = new File("webdriver/chromedriver.exe");
            if(file1.exists()){
                System.out.println("file not exit!");
                System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
                driver=new ChromeDriver();
            }else {
                driver=null;
            }
        }
        return driver;
    }
}

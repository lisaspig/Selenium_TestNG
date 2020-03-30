package com.htht.SeleniumFuc;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

public class RemotDriverInit {
    private  String browser;
    private String  remoturl;
    private String  platform;


    public RemotDriverInit(String remoturl, String platform,String browser) {
        this.browser = browser;
        this.remoturl = remoturl;
        this.platform = platform;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getRemoturl() {
        return remoturl;
    }

    public void setRemoturl(String remoturl) {
        this.remoturl = remoturl;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public  WebDriver getWebdriver(){
        WebDriver driver;
        if(this.remoturl==null){
            Reporter.log("远程路径参数错误");
            driver =null;
        }else {
            URL url = null;
            try {
                url = new URL(remoturl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            DesiredCapabilities capabilities;

            if (browser.equals("firefox")) {
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
            } else if (browser.equals("edge")) {
                capabilities = DesiredCapabilities.edge();
                capabilities.setBrowserName("edge");
            } else {
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
            }
            if (platform.equals("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            } else if (platform.equals("win10")) {
                capabilities.setPlatform(Platform.WIN10);
            } else if (platform.equals("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else{
                capabilities.setPlatform(Platform.ANY);
            }
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new RemoteWebDriver(url, capabilities);

        }
        return driver;
    }


//    private WebDriver chromeDriver(String platform ,URL url){
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities = DesiredCapabilities.chrome();
//        capabilities.setBrowserName("chrome");
//        this.chosePlatform(capabilities,platform);
//        capabilities.setJavascriptEnabled(true);
//        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//
//        WebDriver driver = new RemoteWebDriver(url, capabilities);
//        return driver;
//    }
//
//
//    private void chosePlatform(DesiredCapabilities capabilities,String platform){
//        if (platform.equals("windows")) {
//            capabilities.setPlatform(Platform.WINDOWS);
//        } else if (platform.equals("win10")) {
//            capabilities.setPlatform(Platform.WIN10);
//        } else if (platform.equals("linux")) {
//            capabilities.setPlatform(Platform.LINUX);
//        } else{
//            capabilities.setPlatform(Platform.ANY);
//        }
//    }
}

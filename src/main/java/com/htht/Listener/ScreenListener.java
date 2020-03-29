package com.htht.Listener;

import com.htht.Cases.DriverBase;
import com.htht.SeleniumFuc.ScreenImage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class ScreenListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        takeScreenShot(result);
    }
    private void takeScreenShot(ITestResult result) {
        DriverBase driverBase = (DriverBase)result.getInstance();
        WebDriver driver = driverBase.getDriver();
        ScreenImage screenImage = new ScreenImage();
        screenImage.setDriver(driver);
        try {
           screenImage.screen(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

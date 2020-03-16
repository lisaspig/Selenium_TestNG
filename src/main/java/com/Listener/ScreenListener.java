package com.Listener;

import com.Cases.DriverBase;
import com.SeleniumFuc.SeleniumFuc;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class ScreenListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
//        super.onTestFailure(result);
        DriverBase driverBase =(DriverBase)result.getInstance();
        WebDriver driver = driverBase.getDriver();
        try {
            SeleniumFuc.screenImage(result.getName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

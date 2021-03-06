package com.htht.SeleniumFuc;

import com.htht.Fileutil.PropertiesInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExpected {

    private static String timeout = PropertiesInit.getAsserttimeout();
    //判断当前页面的title是否精确等于预期
    public static boolean titleIs(String titles,WebDriver driver){
        boolean asert =false;
        try {
            asert = new WebDriverWait(driver,Integer.valueOf(timeout)).until(ExpectedConditions.titleIs(titles));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return asert;
    }
    //判断当前页面的title是否包含预期字符串
    public static boolean titleContains(String titles,WebDriver driver){

        return new WebDriverWait(driver,Integer.valueOf(timeout)).until(ExpectedConditions.titleContains(titles));

    }
    // 判断某个元素中的text是否包含了预期的字符串；
    public static boolean textToBePresentInElement(WebDriver driver,WebElement element, String text){
        boolean asert =false;
        try {
            asert = new WebDriverWait(driver,Integer.valueOf(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return asert;
    }
//    判断某个元素中的 value 属性是否包含 了预期的字符串
    public static boolean textToBePresentInElementValue( WebElement element, String text,WebDriver driver){
        boolean asert =false;
        try {
            asert = new WebDriverWait(driver,Integer.valueOf(timeout)).until(ExpectedConditions.textToBePresentInElementValue(element, text));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return asert;
    }

    public static boolean alterIsPasser(String text,Alert alert){
        boolean asert ;
        try {
            if(alert.getText().equals(text)){
                asert=true;
            }else {
                asert =false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            asert = false;
        }
        return  asert;
    }

}

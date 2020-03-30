
package com.htht.SeleniumFuc;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {

    //打开网页
    public static void openPage (WebDriver driver ,String url){
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            Reporter.log(url+"打开失败");
        }
    }
         //点击操作
   public static void clickElment(WebElement element ){
        if(!element.equals(null)){
            element.click();
        }
   }


        //清除输入框，输入字符
    public static void sendKeys(WebElement element,String word){
        if(!element.equals(null)){
            element.clear();
            element.sendKeys(word);
        }
    }

        //获取页面标题
     public static String handleTitle (WebDriver driver ){
        if(driver.getTitle()== null){
            return null;
        }else{
            return driver.getTitle();
        }
    }

        //获取动态元素ID
        public static String getElmenttAttribute(String Attribute,WebElement element){
            if(element.getAttribute(Attribute).equals(null)){
                return  null;
            }
            return  element.getAttribute(Attribute);
        }


        //获取新页面driver
        public static WebDriver SwitchNewWindow(WebDriver driver ){
            String handle = driver.getWindowHandle();
            WebDriver newdriver=null;
            Set<String> handles=driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            while(it.hasNext()){
                if(handle.equals(it.next()) ){
                    continue;
                }
                newdriver=driver.switchTo().window(it.next());
            }
            return  newdriver;
        }

        //JS聚焦点击操作
        public static void jsClikcelement(WebElement element,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript("arguments[0].focus();", element);//获取元素焦点
            js.executeScript("arguments[0].click();", element);	//web元素执行点击操作
        }

        //JS赋值元素
        public static void jsInputid(String id,String newvalue,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;

            String s1 ="document.getElementById('"+id+"').value='"+newvalue+"'";
            js.executeScript(s1);
        }
        //使用JQuery进行元素定位
        public static void JsSelectid(String Id,WebDriver driver ){

            JavascriptExecutor js =(JavascriptExecutor)driver;
            String s1 ="document.querySelector('#"+Id+"')";
            js.executeScript(s1);
        }
        //selenium 执行JS代码通用方法
        public static void jsExcute(String javascript,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(javascript);
        }
        public static void jsExceutbyElement(String javascript,WebElement element,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(javascript,element);

        }
        public static void jsExcuteAsync(String javascript,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeAsyncScript(javascript);
        }

        //通过下拉列表选择
        public static void selectElementbytext(String text,WebElement element){
            Select sel = new Select(element);
            sel.selectByVisibleText(text);//根据文本选择
        }
        public static void selectElementbyindex(String index ,WebElement element){
            int i = Integer.valueOf(index);
            Select sel = new Select(element);
            sel.selectByIndex(i);//根据排序索引选择，从0开始
        }
        public static void selectElementbyValue(String Value, WebElement element){
            Select sel = new Select(element);
            sel.selectByValue(Value);//根据元素标签中的Value属性值选择
        }


        public static void selectAll(String xpath,WebDriver driver ) {
            Select sel = new Select(driver.findElement(By.xpath(xpath)));
            System.out.println("sel.getOptions="+sel.getOptions());
            System.out.println("sel.getAllSelectedOption"+sel.getAllSelectedOptions());

        }


        //iframe 页面转换

        public static WebDriver switchIframebyString(String iframe,WebDriver driver ){
            if(driver.switchTo().frame(iframe).equals(null)){
                return  driver;
            }
            return driver.switchTo().frame(iframe);
        }
        public static WebDriver switchIframebyElement(WebElement element,WebDriver driver ){
            if(driver.switchTo().frame(element).equals(null)){
                return  driver;
            }
            return driver.switchTo().frame(element);
        }

        public static void switchIframebyIndex(String index,WebDriver driver ){
            int i =Integer.valueOf(index);
            if(driver.switchTo().frame(i).equals(null)){
                Reporter.log("无");
            }
            driver.switchTo().frame(i);
        }

        public static void outIframe(WebDriver driver){
           driver.switchTo().defaultContent();
        }


        //页面滚动条操作
        public static void upPage(WebElement element,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",element);//移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        }
        public static void downPage(WebElement element,WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(false);", element);//移动到元素element对象的“底端”与当前窗口的“底部”对齐
        }
        public static void dibuPage(WebDriver driver ){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//移动到页面最底部
        }

        public static void XangsuBy(int x,int y,WebDriver driver ){
            String s1 =String.valueOf(x);
            String s2 =String.valueOf(y);
            String jsdm ="window.scrollBy("+s1+"," +s2+");";
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(jsdm); 	//移动到指定的坐标(相对当前的坐标移动)
        }

        public static void XangsuTo(int x,int y,WebDriver driver ){
            String s1 =String.valueOf(x);
            String s2 =String.valueOf(y);
            String jsdm ="window.scrollTo("+s1+"," +s2+");";
            JavascriptExecutor js =(JavascriptExecutor)driver;  //移动到窗口绝对位置坐标
            js.executeScript(jsdm);
        }
        //通过Action 操作页面鼠标进行鼠标左键点击操作
        public static void actionClick(WebElement element,WebDriver driver ) {
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            action.click(element).perform();
            action.release();
        }

        public static  void actionSendkeys(WebElement element,String keys,WebDriver driver ) {
            Actions action = new Actions(driver);
            action.sendKeys(element,keys).perform();
            action.release();
        }
//        弹出框点击操作
        public static String alertConfrim(String action,String timeout,WebDriver driver ){

            try {
                Alert alert = new WebDriverWait(driver,Integer.valueOf(timeout)).until(ExpectedConditions.alertIsPresent());
                    if (action.equals("关闭") || action.equals("取消")) {
                        alert.dismiss();
                    } else {
                        alert.accept();
                    }
                    return alert.getText();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                    return null;
            }
        }
    //  弹出框输入操作
        public static String prompt(String keys,WebDriver driver ){
            Alert alert = null;
            try {
                alert = driver.switchTo().alert();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(alert!=null) {
                alert.sendKeys(keys);
                alert.accept();
                return alert.getText();
            }else{
                return  null;
            }
        }

}


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

public class SeleniumFuc {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

        //打开网页
    public void OpenPage (String url){
        try {
            this.driver.get(url);
            this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        } catch (Exception e) {
            Reporter.log(url+"打开失败");
        }
    }
         //点击操作
   public void clickElment(WebElement element ){
        if(!element.equals(null)){
            element.click();
        }
   }


        //清除输入框，输入字符
    public void sendKeys(WebElement element){
        if(!element.equals(null)){
            element.clear();
            element.sendKeys();
        }
    }

        //获取页面标题
     public String handleTitle (){
        if(this.driver.getTitle()== null){
            return null;
        }else{
            return this.driver.getTitle();
        }
    }

        //获取动态元素ID
        public String getElmenttAttribute(String Attribute,WebElement element){
            if(element.getAttribute(Attribute).equals(null)){
                return  null;
            }
            return  element.getAttribute(Attribute);
        }


        //获取新页面driver
        public WebDriver SwitchNewWindow(){
            String handle = this.driver.getWindowHandle();
            WebDriver newdriver=null;
            Set<String> handles=this.driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            while(it.hasNext()){
                if(handle.equals(it.next()) ){
                    continue;
                }
                newdriver=this.driver.switchTo().window(it.next());
            }
            return  newdriver;
        }

        //JS聚焦点击操作
        public void jsClikcelement(WebElement element){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            js.executeScript("arguments[0].focus();", element);//获取元素焦点
            js.executeScript("arguments[0].click();", element);	//web元素执行点击操作
        }

        //JS赋值元素
        public void jsInputid(String id,String newvalue){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;

            String s1 ="document.getElementById('"+id+"').value='"+newvalue+"'";
            js.executeScript(s1);
        }
        //使用JQuery进行元素定位
        public void JsSelectid(String Id){

            JavascriptExecutor js =(JavascriptExecutor)driver;
            String s1 ="document.querySelector('#"+Id+"')";
            js.executeScript(s1);
        }
        //selenium 执行JS代码通用方法
        public void jsExcute(String javascript){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(javascript);
        }
        public void jsExceutbyElement(String javascript,WebElement element){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(javascript,element);

        }
        public void jsExcuteAsync(String javascript){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeAsyncScript(javascript);
        }

        //通过下拉列表选择
        public void selectElementbytext(String text,WebElement element){
            Select sel = new Select(element);
            sel.selectByVisibleText(text);//根据文本选择
        }
        public void selectElementbyindex(String index ,WebElement element){
            int i = Integer.valueOf(index);
            Select sel = new Select(element);
            sel.selectByIndex(i);//根据排序索引选择，从0开始
        }
        public void selectElementbyValue(String Value, WebElement element){
            Select sel = new Select(element);
            sel.selectByValue(Value);//根据元素标签中的Value属性值选择
        }


        public void selectAll(String xpath) {
            Select sel = new Select(this.driver.findElement(By.xpath(xpath)));
            System.out.println("sel.getOptions="+sel.getOptions());
            System.out.println("sel.getAllSelectedOption"+sel.getAllSelectedOptions());

        }


        //iframe 页面操作代码开始

        public WebDriver switchIframe(String iframe){
            if(this.driver.switchTo().frame(iframe).equals(null)){
                return  this.driver;
            }
            return this.driver.switchTo().frame(iframe);
        }
        public WebDriver switchIframebyIndex(String index){
            int i =Integer.valueOf(index);
            if(this.driver.switchTo().frame(i).equals(null)){
                return  this.driver;
            }
            return this.driver.switchTo().frame(i);
        }


        //页面滚动条操作
        public void upPage(WebElement element){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            js.executeScript("arguments[0].scrollIntoView(true);",element);//移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        }
        public void downPage(WebElement element){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            js.executeScript("arguments[0].scrollIntoView(false);", element);//移动到元素element对象的“底端”与当前窗口的“底部”对齐
        }
        public void dibuPage(){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//移动到页面最底部
        }

        public void XangsuBy(int x,int y){
            String s1 =String.valueOf(x);
            String s2 =String.valueOf(y);
            String jsdm ="window.scrollBy("+s1+"," +s2+");";
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            js.executeScript(jsdm); 	//移动到指定的坐标(相对当前的坐标移动)
        }

        public void XangsuTo(int x,int y){
            String s1 =String.valueOf(x);
            String s2 =String.valueOf(y);
            String jsdm ="window.scrollTo("+s1+"," +s2+");";
            JavascriptExecutor js =(JavascriptExecutor)this.driver;  //移动到窗口绝对位置坐标
            js.executeScript(jsdm);
        }
        //通过Action 操作页面鼠标进行鼠标左键点击操作
        public void actionClick(WebElement element) {
            Actions action = new Actions(this.driver);
            action.moveToElement(element).perform();
            action.click(element).perform();
            action.release();
        }

        public void actionSendkeys(WebElement element,String keys) {
            Actions action = new Actions(this.driver);
            action.sendKeys(element,keys).perform();
            action.release();
        }
//        弹出框点击操作
        public String alertConfrim(String action,String timeout){

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
        public String prompt(String keys){
            Alert alert = null;
            try {
                alert = this.driver.switchTo().alert();
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

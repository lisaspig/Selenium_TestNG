
package com.SeleniumFuc;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class seleniumFuc {

        private WebDriver driver;



        public seleniumFuc(WebDriver _driver) {
            this.driver = _driver;
        }

        public WebDriver getdriver() {
            return this.driver;
        }

        //创建文件夹，将截图文件保存至文件夹内
        public void SSfile(String filename,String imagepath)throws IOException, InterruptedException{
            File file = new File(imagepath);
            if(!file.exists()){
                file.mkdir();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");//设置时间格式
            String Datatime = df.format(new Date());//获取当前时间
            File ssfile = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(ssfile, new File("D:/test/"+filename+Datatime+".png"));
        }

        //打开网页
        public void OpenPage (String url){
            this.driver.get(url);

            this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        }

        public void closePage() {
            this.driver.close();
        }

        public boolean checkElemntDisplayed(String element) {

            if(this.driver.findElement(By.id(element)).isDisplayed()|this.driver.findElement(By.className(element))
                    .isDisplayed()|this.driver.findElement(By.xpath(element)).isDisplayed()) {
                return true;
            }else {
                return false;
            }

        }
        //点击操作
        public void clickid(String ID ){

            this.driver.findElement(By.id(ID)).click();

        }
        public void clickxpath(String Xpath ){

            this.driver.findElement(By.xpath(Xpath)).click();
        }

        public void clickLInktext(String Linktext) {
            this.driver.findElement(By.linkText(Linktext)).click();
        }
        public void clicktext(String text ){
            WebElement element =this.driver.findElement(By.linkText(text));
            if(element.isDisplayed()){
                element.click();
            }else{
                System.out.println("Element: "+text+"  cannot find");
            }
        }

        //清除输入框，输入操作
        public void sendkeysid(String ID,String keys){
            WebElement element =this.driver.findElement(By.id(ID));

            if(element.isDisplayed()){
                if((element.getText()!=null)|(element.getAttribute("value")!=null)){
                    element.clear();
                }
                element.sendKeys(keys);
            }else{
                System.out.println("Element: "+ID+"  cannot find");
            }
        }
        public void sendkeysxpath(String Xpath,String keys){
            WebElement element =this.driver.findElement(By.xpath(Xpath));
            if(element.isDisplayed()){
                if((element.getText()!=null)|(element.getAttribute("value")!=null)){
                    element.clear();
                }
                element.sendKeys(keys);
            }else{
                System.out.println("Element: "+Xpath+"  cannot find");
            }
        }
        //获取元素值
        public String elemenIDtext (String id){
            WebElement element = this.driver.findElement(By.id(id));
            if(element.isDisplayed()){
                return element.getText();
            }else{
                return null;
            }
        }
        public String elemenXpathtext (String xpath){
            WebElement element =this.driver.findElement(By.xpath(xpath));

            if(element.isDisplayed()&&element.getText()!=null){
                return element.getText();
            }else{
                return null;
            }
        }
        //获取页面标题
        public String handletitle (){

            if(this.driver.getTitle()== null){
                return null;
            }else{
                return this.driver.getTitle();
            }
        }

        //获取动态元素ID
        public String DongTaiID(String xpath){
            return 	this.driver.findElement(By.xpath(xpath)).getAttribute("id");
        }
        //获取页面句柄，转换页面
        public WebDriver Switchh( WebDriver _driver){
            String handle = _driver.getWindowHandle();
            return _driver.switchTo().window(handle);
        }

        public WebDriver SwitchNewWindow(){
            String handle = this.driver.getWindowHandle();
            WebDriver ndriver=null;
            Set<String> handles=this.driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            while(it.hasNext()){
                if(handle.equals(it.next()) ){
                    continue;
                }
                ndriver=this.driver.switchTo().window(it.next());
            }
            return  ndriver;
        }


        //窗口最大化
        public void maxwindow(){
            //	final JavascriptExecutor js = (JavascriptExecutor)driver;
            //	js.executeScript(arg0, arg1)
            this.driver.manage().window().maximize();
        }
        //js代码操作
        public void Jsclikcxpath(String Xpath){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            WebElement web =this.driver.findElement(By.xpath(Xpath));
            js.executeScript("arguments[0].focus();", web);
            js.executeScript("arguments[0].click();", web);	//web元素执行点击操作
        }

        public void jsFoucesXpath(String Xpath){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            WebElement web =this.driver.findElement(By.xpath(Xpath));
            js.executeScript("arguments[0].focus();", web);	//获取元素焦点

        }
        public void Jsinputid(String Id,String value){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            String s1 ="document.getElementById('"+Id+"').value=''"+value;
            js.executeScript(s1);
        }
        public void JsSelectid(String Id){

            JavascriptExecutor js =(JavascriptExecutor)driver;
            String s1 ="document.querySelector('#"+Id+"')";
            js.executeScript(s1);
        }

        public void JsExcute(String Javascript){
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(Javascript);
        }
        public void JsExcutBy_Xpath(String Javascript,String Xpath){
            WebElement web =this.driver.findElement(By.xpath(Xpath));
            JavascriptExecutor js =(JavascriptExecutor)driver;
            js.executeScript(Javascript,web);
        }

        //通过xpath选元素
        public void selectElementbytext_xpath (String text,String xpath){
            Select sel = new Select(this.driver.findElement(By.xpath(xpath)));
            sel.selectByVisibleText(text);//根据文本选择
            System.out.println("select");
        }
        public void selectElementbyindex_xpath(int index ,String xpath){
            Select sel = new Select(this.driver.findElement(By.xpath(xpath)));
            sel.selectByIndex(index);//根据排序索引选择，从0开始
        }
        public void selectElementbyValue_xpath(String Value ,String id){
            Select sel = new Select(this.driver.findElement(By.id(id)));
            sel.selectByValue(Value);//根据元素标签中的Value属性值选择
        }
        //通过id选择元素
        public void selectElementbytext_id (String text,String id){
            Select sel = new Select(this.driver.findElement(By.id(id)));
            sel.selectByVisibleText(text);//根据文本选择
            System.out.println("select");
        }
        public void selectElementbyindex_id(int index ,String id){
            Select sel = new Select(this.driver.findElement(By.id(id)));
            sel.selectByIndex(index);//根据排序索引选择，从0开始
        }
        public void selectElementbyValue_id(String Value ,String id){
            Select sel = new Select(this.driver.findElement(By.id(id)));
            sel.selectByValue(Value);//根据元素标签中的Value属性值选择

        }

        public void selectAll(String xpath) {
            Select sel = new Select(this.driver.findElement(By.xpath(xpath)));
            System.out.println("sel.getOptions="+sel.getOptions());
            System.out.println("sel.getAllSelectedOption"+sel.getAllSelectedOptions());

        }



        //iframe 页面操作代码开始

        public WebDriver SwitchiframebyId(String iframeId){
            return this.driver.switchTo().frame(iframeId);
        }
        public WebDriver SwitchiframebyIndex(int index){
            return this.driver.switchTo().frame(index);
        }
        public WebDriver SwitchiframebyName(String iframeName){
            return this.driver.switchTo().frame(iframeName);
        }
        public WebDriver SwitchiframebyElement(String iframeXpath){
            return this.driver.switchTo().frame(driver.findElement(By.xpath(iframeXpath)));
        }
        public void outiframe(){
            this.driver.switchTo().defaultContent();//返回默认窗口
        }
        public void upperiframe (){
            this.driver.switchTo().parentFrame();//返回上一级iframe页面
        }

        //页面滚动条操作
        public void UPpage(String xpath){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            WebElement web =driver.findElement(By.xpath(xpath));
            js.executeScript("arguments[0].scrollIntoView(true);", web);//移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        }
        public void Downpage(String xpath){
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            WebElement web =this.driver.findElement(By.xpath(xpath));
            js.executeScript("arguments[0].scrollIntoView(false);", web);//移动到元素element对象的“底端”与当前窗口的“底部”对齐
        }
        public void Downpage(){
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
            JavascriptExecutor js =(JavascriptExecutor)this.driver;
            //移动到窗口绝对位置坐标
            js.executeScript(jsdm);
        }
        //通过Action 操作页面鼠标进行鼠标左键点击操作
        public void actionClickXpath(String xpath) {
            Actions action = new Actions(this.driver);
            WebElement element =this.driver.findElement(By.xpath(xpath));
            action.moveToElement(element).perform();

            action.click(element).perform();;

        }
        public void actionClickId(String Id) {
            Actions action = new Actions(this.driver);
            WebElement element = this.driver.findElement(By.id(Id));
            action.moveToElement(element).perform();
            action.click(element).perform();
        }


}

package com.RunCases;

import com.Cases.FirstPageCases;
import com.GetJson.GetJsonString;
import com.GetJson.ReadSingleton;
import com.SeleniumFuc.getDriver;
import com.SeleniumFuc.seleniumFuc;
import com.TestNgFuc.DataProviderCase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Map;

public class runCases {


        public static String userdir = System.getProperty("user.dir");
        public static String foxdriverpath =userdir+"\\Webdriver\\geckodriver.exe";
        public static String chormriverpath = userdir+"\\Webdriver\\chromedriver.exe";
        public static String firstpageJsonPath =userdir+"\\Jsonfiles\\FirstPageEle.json";
        public static String congfigJsonpath = userdir+"\\Jsonfiles\\config.json";
        public static String JiBenCZ_Ele="JiBenCZ_Ele";
        public static String AddL2_Ele="AddL2_Ele";
        public static String Band_Ele="Band_Ele";
        public static String L2Select_Ele="AddL2_Select_values";


        Map<String, Object> config_Map=null;
        Map<String, Object> JiBenCZ_Map =null;
        Map<String, Object> L2_Map =null;
        Map<String, Object> Band_Map=null;
        Map<String, Object> L2Select_Map =null;

        WebDriver driver;
        JavascriptExecutor js;
        Actions action;
        seleniumFuc fuc ;
        GetJsonString getFirstPageEles;
        GetJsonString getConfigEles;
        FirstPageCases FirstPage ;


        //初始化页面操作要素和配置文件,以LinkedHashMap呈现Json文件中的key和value
        @BeforeTest
        public void getMap() {
            try {
                this.config_Map = this.getConfigEles.getL1Ele();
                this.L2_Map = this.getFirstPageEles.getL2Ele(AddL2_Ele);
                this.JiBenCZ_Map = this.getFirstPageEles.getL2Ele(JiBenCZ_Ele);
                this.Band_Map = this.getFirstPageEles.getL2Eletreemap(Band_Ele);
                this.L2Select_Map = this.getFirstPageEles.getL2Ele(L2Select_Ele);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        //初始化
        @BeforeTest
        public void Chushihua() {
//		System.setProperty("webdriver.chorme.driver",chormriverpath);
            System.out.println(chormriverpath);
            System.out.println(firstpageJsonPath);
            this.getFirstPageEles = new GetJsonString(ReadSingleton.getjsonfile(firstpageJsonPath));
            this.getConfigEles = new GetJsonString(ReadSingleton.getjsonfile(congfigJsonpath));
//		this.driver = new GetDriver1(chormriverpath).chdriver1();
            this.driver = new getDriver(foxdriverpath).foxdriver();
            this.fuc = new seleniumFuc(this.driver);
            this.FirstPage = new FirstPageCases(this.fuc);

        }


        @Test
        public void openpage() {
            FirstPage.openpage(this.JiBenCZ_Map.get("首页_URL").toString());
        }

        //检查二级产品case，element 使用参数化
//	@Test(testName= "产品检查",dataProvider = "test",priority =2)
        public void l2Check(String element){
            String buttonElement = JiBenCZ_Map.get("产品_Select_id").toString();
            FirstPage.l2Check(buttonElement,element);
        }

        //	@Test(testName= "测试",priority =3,dataProvider = "test")
        public void testself(Object test) {
            String buttonElement = JiBenCZ_Map.get("通道_Button_id").toString();
            FirstPage.testself(buttonElement,test);

        }
        //检查通道case，element 使用参数化
//	@Test(testName= "通道检查",dataProvider = "bengCheck",priority =4,alwaysRun =true)
        public void bengCheck(String element) {
            String buttonElement = JiBenCZ_Map.get("通道_Button_id").toString();
            FirstPage.bengCheck(buttonElement,element);

        }

        @AfterTest
        public void endtest() {

            FirstPage.closeDriver();
        }

        @DataProvider(name = "l2Check")
        public Object[][] l2CheckProvider(){

            return new DataProviderCase().getDataProvider(L2_Map);
        }

        @DataProvider(name = "SelectL2")
        public Object[][] l2SelectCheckProvider(){

            return new DataProviderCase().getDataProvider(L2Select_Map);
        }

        @DataProvider(name = "bengCheck")
        public Object[][] bengCheckProvider(){

            return new DataProviderCase().getDataProvider(Band_Map);
        }

        @DataProvider(name = "test")
        public Object[][] test(){

            return new DataProviderCase().getDataProvider1(Band_Map);

        }
        @DataProvider(name = "test2")
        public Object[][] test2(){

            return new DataProviderCase().getDataProvider2(Band_Map);
        }

        public static void main(String[] args) {
            System.out.println(userdir);
            TestNG tng = new TestNG();
            List<String> suites = Lists.newArrayList();
            //添加要执行的testng.xml文件
            suites.add(userdir+"/tNG_Xml/testNg.xml");
            tng.setTestSuites(suites);
            tng.run();
        }
}

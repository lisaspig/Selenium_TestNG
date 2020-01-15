package com.Cases;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.SeleniumFuc.seleniumFuc;

public class FirstPageCases {

        JavascriptExecutor js;
        Actions action;

        seleniumFuc fuc ;

        public FirstPageCases(seleniumFuc _fuc) {
            this.fuc=_fuc;
        }
        public void openpage(String Url) {
            fuc.OpenPage(Url);
            fuc.maxwindow();
        }

        //检查二级产品case，element 使用参数化
        public void l2Check(String buttonElement,String element){
            try {
                fuc.clickid(buttonElement);
                Thread.sleep(3000);
                if(fuc.checkElemntDisplayed(element)) {
                    if(element == "ui-id-27"|element == "ui-id-28"|element == "ui-id-29") {

                    }
                    System.out.println("yes");
//				fuc.Jsclikcxpath(ele3);
                    fuc.actionClickXpath(element);
                    Thread.sleep(5000);
                }

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }

        public void testself(String  buttonElement,Object test) {
            String Jquerysprit = "$(\"#ui-id-8\").click();";
            String Jquerysprit1 = "$(\"#ui-id-8\").attr(\"class\",\"ui-menu-item-wrapper ui-state-active\");";
            String Jquerysprit2 = "$(\"#ui-id-15\").attr(\"class\",\"ui-menu-item-wrapper\");";
            String Jquerysprit3 = "$(\"#sectorSelectorBand-menu\").attr(\"aria-activedescendant\",\"ui-id-8\");";
            String Jquerysprit4 = "$(\"#sectorSelectorBand-button\").attr(\"aria-activedescendant\",\"ui-id-8\");";

            try {
                Thread.sleep(1000);
                fuc.clickid(buttonElement);
                Thread.sleep(3000);
                fuc.JsExcute(Jquerysprit1);
                fuc.JsExcute(Jquerysprit2);
                fuc.JsExcute(Jquerysprit3);
                fuc.JsExcute(Jquerysprit4);
                Thread.sleep(1000);
                fuc.JsExcute(Jquerysprit);
                Thread.sleep(2000);

//			fuc.sendkeysid("ui-id-8", Keys.ENTER);
//
//			fuc.actionSendKey(Keys.ENTER);
//
            } catch (InterruptedException e) {

                e.printStackTrace();
            }


        }
        //检查通道case，element 使用参数化
        public void bengCheck(String buttonElement ,String element) {

            try {
                Thread.sleep(1000);
                fuc.clickid(buttonElement);
                Thread.sleep(1000);
                fuc.actionClickId(element);
                Thread.sleep(5000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
        public void closeDriver() {
            fuc.closePage();
        }

}


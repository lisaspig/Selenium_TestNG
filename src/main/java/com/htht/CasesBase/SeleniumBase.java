package com.htht.CasesBase;

import com.htht.SeleniumFuc.LocatElement;
import com.htht.SeleniumFuc.SeleniumAction;
import com.htht.SeleniumFuc.SeleniumExpected;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SeleniumBase {

    private static final String KEYWORD = "Keyword";
    private static final String VALUE = "Value";
//    private static final String TYPE = "Type";
    private static final String TIMEOUT = "Timeout";

    private static final String KEY_URL = "url";
    private static final String KEY_SENDKEY= "sendkey";
    private static final String KEY_CLICK= "click";
    private static final String KEY_SELECT= "select";
    private static final String KEY_DESELECT= "deselect";
    private static final String KEY_SELECT_ALL= "select_all";
    private static final String KEY_DESELECT_ALL= "deselect_all";
    private static final String KEY_ACTION_CLICK= "action_click";
    private static final String KEY_ACTION_SEND= "action_send";
    private static final String KEY_JS= "js";
    private static final String KEY_JS_ELE= "js_ele";
    private static final String KEY_IFRAME="iframe";
    private static final String KEY_IFRAME_OUT="iframe_out";
    private static final String KEY_ASSERT= "assert";


    private  HashMap<String,HashMap<String,String>> elemap;
    private  HashMap<String,List<String>> datamap;
    private WebDriver driver;

    public void craetStep1(String parame){
        LocatElement locatElement = new LocatElement(driver,elemap);
       for(String stepname : elemap.keySet() ){
          HashMap<String,String> hash = elemap.get(stepname);
          String keyword = hash.get(KEYWORD);

//          switch (switchMathod){
//              case KEY_URL:
//                  SeleniumAction.openPage(driver,hash.get(VALUE));
//              case KEY_CLICK:
//                  SeleniumAction.clickElment(element);
//              case KEY_SEND:
//                  SeleniumAction.sendKeys(element,parame);
//              case KEY_SELECT:
//                  this.selectKey(parame,element);
//              case KEY_SELECT_ALL:
//                  SeleniumAction.selectAll(element);
//              case KEY_DESELECT_ALL:
//                  SeleniumAction.deselectAll(element);
//              case KEY_DESELECT:
//                  this.deselectKey(parame,element);
//              case KEY_ACTION_CLICK:
//                  SeleniumAction.actionClick(element,driver);
//              case KEY_ACTION_SEND:
//                  SeleniumAction.actionSendkeys(parame,element,driver);
//              case KEY_JS:
//                  SeleniumAction.jsExcute(parame,driver);
//              case KEY_JS_ELE:
//                  SeleniumAction.jsExcutebyElement(parame,element,driver);
//              case KEY_IFRAME:
//                  this.switchIfram(parame,element,driver);
//              case KEY_IFRAME_OUT:
//                  SeleniumAction.outIframe(driver);
//              case KEY_ASSERT:
//                  this.assertKey(parame,hash.get(TIMEOUT),element,driver);
//          }
           if(keyword.equals(KEY_URL)){
               SeleniumAction.openPage(driver,hash.get(VALUE));
           }else if (keyword.equals(KEY_CLICK)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.clickElment(element);
           } else if(keyword.equals(KEY_SENDKEY)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.sendKeys(element,parame);
           }else if(keyword.equals(KEY_SELECT)){
               WebElement element =locatElement.getElement(stepname);
               this.selectKey(parame,element);
           }else if(keyword.equals(KEY_SELECT_ALL)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.selectAll(element);
           }else if(keyword.equals(KEY_DESELECT_ALL)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.deselectAll(element);
           } else if(keyword.equals(KEY_DESELECT)){
               WebElement element =locatElement.getElement(stepname);
               this.deselectKey(parame,element);
           }else if(keyword.equals(KEY_ACTION_CLICK)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.actionClick(element,driver);
           }else if(keyword.equals(KEY_ACTION_SEND)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.actionSendkeys(parame,element,driver);
           }else if(keyword.equals(KEY_JS)){
               SeleniumAction.jsExcute(parame,driver);
           }else if(keyword.equals(KEY_JS_ELE)){
               WebElement element =locatElement.getElement(stepname);
               SeleniumAction.jsExcutebyElement(parame,element,driver);
           }else if(keyword.equals(KEY_IFRAME)){
               WebElement element =locatElement.getElement(stepname);
                this.switchIfram(parame,element,driver);
           }else if (keyword.equals(KEY_IFRAME_OUT)){
               SeleniumAction.outIframe(driver);
           }else if(keyword.equals(KEY_ASSERT)){
               WebElement element =locatElement.getElement(stepname);
                this.assertKey(parame,hash.get(TIMEOUT),element,driver);
           }
       }
    }

    public void creatStep(String keyword,HashMap<String,String> hash,String parame,String stepname,LocatElement locatElement){
        if(keyword.equals(KEY_URL)){
            SeleniumAction.openPage(driver,parame);
        }else if (keyword.equals(KEY_CLICK)){
            SeleniumAction.clickElment(locatElement.getElement(stepname));
        } else if(keyword.equals(KEY_SENDKEY)){
            SeleniumAction.sendKeys(locatElement.getElement(stepname),parame);
        }else if(keyword.equals(KEY_SELECT)){
            this.selectKey(parame,locatElement.getElement(stepname));
        }else if(keyword.equals(KEY_SELECT_ALL)){
            SeleniumAction.selectAll(locatElement.getElement(stepname));
        }else if(keyword.equals(KEY_DESELECT_ALL)){
            SeleniumAction.deselectAll(locatElement.getElement(stepname));
        } else if(keyword.equals(KEY_DESELECT)){
            this.deselectKey(parame,locatElement.getElement(stepname));
        }else if(keyword.equals(KEY_ACTION_CLICK)){
            SeleniumAction.actionClick(locatElement.getElement(stepname),driver);
        }else if(keyword.equals(KEY_ACTION_SEND)){
            SeleniumAction.actionSendkeys(parame,locatElement.getElement(stepname),driver);
        }else if(keyword.equals(KEY_JS)){
            SeleniumAction.jsExcute(parame,driver);
        }else if(keyword.equals(KEY_JS_ELE)){
            SeleniumAction.jsExcutebyElement(parame,locatElement.getElement(stepname),driver);
        }else if(keyword.equals(KEY_IFRAME)){
            this.switchIfram(parame,locatElement.getElement(stepname),driver);
        }else if (keyword.equals(KEY_IFRAME_OUT)){
            SeleniumAction.outIframe(driver);
        }else if(keyword.equals(KEY_ASSERT)){
            this.assertKey(parame,hash.get(TIMEOUT),locatElement.getElement(stepname),driver);
        }
    }


    private void selectKey(String parame,WebElement element){
        String[] split= parame.split("\\.");
        if(split[0].equals("index")){
            SeleniumAction.selectElementbyIndex(split[1],element);
        }else if (split[0].equals("text")){
            SeleniumAction.selectElementbyText(split[1],element);
        }else if (split[0].equals("value")){
            SeleniumAction.selectElementbyValue(split[1],element);
        }
    }
    private void deselectKey(String parame,WebElement element){
        String[] split= parame.split("\\.");
        if(split[0].equals("index")){
            SeleniumAction.deselectElementbyIndex(split[1],element);
        }else if (split[0].equals("text")){
            SeleniumAction.deselectElementbyText(split[1],element);
        }else if (split[0].equals("value")){
            SeleniumAction.deselectElementbyValue(split[1],element);
        }
    }

    private void switchIfram(String parame,WebElement element,WebDriver driver){
        if(element!=null){
            SeleniumAction.switchIframebyElement(element,driver);
        } else if (parame!=null){
            String[] split= parame.split("\\.");
            if(split[0].equals("index")){
                SeleniumAction.switchIframebyIndex(split[1],driver);
            }else if (split[0].equals("text")){
                SeleniumAction.switchIframebyString(split[1],driver);
            }
        }else {
            System.out.println("No Iframe paramter !");
        }
    }

    private void assertKey(String parame,String timeout,WebElement element,WebDriver driver) {
        if (parame!=null){
            String[] split = parame.split("\\.");
            if(split[0].equals("isTitle")){
                SeleniumExpected.titleIs(split[1],timeout,driver);
            }else if (split[0].equals("containsTitle")){
                SeleniumExpected.titleContains(split[1],timeout,driver);
            }
        }
    }
}

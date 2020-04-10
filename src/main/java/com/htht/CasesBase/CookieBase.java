package com.htht.CasesBase;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.PaserJsonfile;
import com.htht.Fileutil.PropertiesInit;
import com.htht.Fileutil.WriteInstance;
import com.htht.General.RegexString;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Set;

public class CookieBase{

    private static JSONObject object = PaserJsonfile.getJobject(PropertiesInit.getCookiefilepath());

    public static void addCookieFromJson( String name, WebDriver driver){
        if(object!=null){
            String cookiestr = object.getJSONObject(name).toString();
            Cookie cookie = new Cookie(name,cookiestr);
            driver.manage().addCookie(cookie);
        }
    }
    public static String getCookeibyRegex(String regex,WebDriver driver){
        String cookies = driver.manage().getCookies().toString();
        return RegexString.getRegexStr(cookies,regex);
    }

    public static void addAllCookieFromJson(WebDriver driver){
        try {
            if(object!=null){
               for(String key : object.keySet()){
                   Cookie cookie = new Cookie(key,object.get(key).toString());
                   driver.manage().addCookie(cookie);
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCookieJson(WebDriver driver){
        Set<Cookie> set = driver.manage().getCookies();
        HashMap<String,String> map = new HashMap<>();
        for(Cookie cookie : set){
            map.put(cookie.getName(),cookie.getValue());
        }
        String jsonString = JSONObject.toJSONString(map,true);
        WriteInstance.getInstance().fileWrite(PropertiesInit.getCookiefilepath(),jsonString);
    }
}

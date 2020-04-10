package com.htht.General;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexString {

    public static String getRegexStr(String str,String reg){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        String result = "";
        if(matcher.find()){
            result = matcher.group(1);
        }
        return result;
    }
}

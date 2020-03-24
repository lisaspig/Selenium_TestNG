package com.htht.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class PaserJsonfile {

    public static JSONObject getJobject(String readstr){
        JSONObject object;
        try {
            object = JSON.parseObject(readstr, Feature.OrderedField);
        } catch (Exception e) {
            e.printStackTrace();
            object= new JSONObject();
        }
        return  object;
    }
}

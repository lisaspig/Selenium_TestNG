package com.htht.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.awt.*;

public class PaserJsonfile {

    public static JSONObject getJobject(String filepath){
        JSONObject object;
        try {
            object = JSON.parseObject(ReadInstance.getInstance().getjsonfile(filepath), Feature.OrderedField);
        } catch (Exception e) {
            e.printStackTrace();
            object= new JSONObject();
        }
        return  object;
    }
}

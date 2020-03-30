package com.htht.Cases;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.PaserJsonfile;

public class DataBase {
    public JSONObject getJsonToObject(String filepath){
        return PaserJsonfile.getJobject(filepath);
    }

}

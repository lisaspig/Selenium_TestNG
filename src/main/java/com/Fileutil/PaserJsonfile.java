package com.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PaserJsonfile {
    private String readstr;
    public PaserJsonfile(String _readstr) {
        this.readstr = _readstr;
    }
    public JSONObject getJobject(){
        JSONObject job = null;
        try {
            job = JSON.parseObject(readstr);
        } catch (Exception e) {
            e.printStackTrace();
            job= new JSONObject();
        }
        return  job;
    }
}

package com.Fileutil;

import com.alibaba.fastjson.JSONObject;

public class GetConf extends PaserJsonfile {

    public GetConf(String _readstr) {
        super(_readstr);
    }
    public JSONObject driverConf(){
       return  super.getJobject();
    }
}

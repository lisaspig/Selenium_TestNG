package com.htht.CasesBase;

import com.alibaba.fastjson.JSONObject;
import com.htht.Fileutil.PaserJsonfile;

import java.util.HashMap;

public class DataBase {

    JSONObject object ;
    public JSONObject getJsonToObject(String filepath){
        this.object = PaserJsonfile.getJobject(filepath);
        return this.object;
    }
//    public HashMap<String,HashMap<String,String>> getHashEle(){
////        this.object.
////        return;
//    }

}

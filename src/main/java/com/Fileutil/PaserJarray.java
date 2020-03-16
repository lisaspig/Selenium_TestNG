package com.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class PaserJarray extends PaserJsonfile {
    private static final String actions = "actions";
    private static final String setvalues = "setvalues";
    public PaserJarray(String _readstr) {
        super(_readstr);
    }
    public  List<ActionInit> getActions(){
        List<ActionInit> result = null;
        try {
            JSONArray jarray = super.getJobject().getJSONArray(actions);
            result = JSON.parseArray(jarray.toJSONString(), ActionInit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object[][]getSetvlues(){
        Object result [][] =null;
        try {
            JSONArray jarray = super.getJobject().getJSONArray(setvalues);
            result = new Object[jarray.size()][jarray.getJSONObject(0).size()];
            for(int i=0;i<jarray.size();i++){
                for (int j=0;j<jarray.getJSONObject(0).size();i++){
                    JSONObject obj = jarray.getJSONObject(i);
                    result[i][j] =obj.get("value"+j+1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
}

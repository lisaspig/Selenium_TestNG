package com.htht.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class GetCases {

    public static HashMap<String,HashMap<String,String>>getEle(JSONObject object, String keyword){

        HashMap<String,HashMap<String,String>> resultmap = new HashMap<>();
        HashMap<String,String> valuemap = new HashMap<>();
        JSONObject ob = object.getJSONObject(keyword);

        for( String key :ob.keySet()){
            try {
                valuemap = JSON.parseObject(ob.getJSONObject(key).toJSONString(),HashMap.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultmap.put(key,valuemap);
            System.out.println(resultmap.get(key).toString());
          }
            return resultmap;
    }


    public static Object[][]getData(JSONObject object,String keyWord){
        Object result [][] =null;
        try {
            JSONArray jarray = object.getJSONArray(keyWord);
            if (!jarray.equals(null)){
                result = new Object[jarray.size()][jarray.getJSONObject(0).size()];
                for(int i=0;i<jarray.size();i++){
                    JSONObject obj = jarray.getJSONObject(i);
                    int j =0;
                    for(String key :obj.keySet()){
                        result[i][j]=obj.get(key).toString();
                        System.out.println( result[i][j]);
                        j++;
                    }
                }
            }else {
               result=null;
            }
        } catch (Exception e) {
            result=null;
        }
        return result;
    }
}

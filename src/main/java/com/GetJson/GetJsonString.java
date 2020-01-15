package com.GetJson;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

//将json读取的结果转换为Map
public class GetJsonString {
    String readFileString;
    public GetJsonString(String _readFileString) {
        this.readFileString = _readFileString;
    }

    public Map<String, Object> getL2Ele(String element){
      JSONObject object = JSONObject.parseObject(readFileString);
      String params = object.getString(element);
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> linkedhashMap=JSON.parseObject(params, LinkedHashMap.class);
        return linkedhashMap;

    }
    public Map<String, Object> getL1Ele(){
        JSONObject object = JSONObject.parseObject(readFileString);
        String params = object.toString();
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Object> linkedhashMap=JSON.parseObject(params, LinkedHashMap.class);
        return linkedhashMap;
    }

    public Map<String, Object> getL2Eletreemap(String element){
        JSONObject object = JSONObject.parseObject(readFileString);
        String params = object.getString(element);
        @SuppressWarnings("unchecked")
        TreeMap<String, Object> treehashMap=JSON.parseObject(params, TreeMap.class);
        return treehashMap;
    }
}

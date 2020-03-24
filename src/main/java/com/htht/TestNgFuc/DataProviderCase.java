package com.htht.TestNgFuc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataProviderCase {

    public Object [][] getDataProvider(Map<String, Object> map){
        Object array[][] = null;
        List<Object> list = null ;
        if(map.size()!=0) {
            list  =new ArrayList<Object>(map.values());
            System.out.println(list);
            array = new Object[list.size()][0];
            for(int i = 0;i<list.size();i++) {
                array[i][0] = list.get(i);
            }
        }else {
            new Exception(map+"is null!");
        }
        return array;
    }
    //json->map中的 value 加入数组
    public Object [][] getDataProvider1(Map<String, Object> map){
        Object array[][] = new Object[map.size()][1];
        if(map.size()!=0) {
            int i = 0;
            for(Entry<String, Object> vo : map.entrySet()) {
                array[i][0] = vo.getValue();
                i++;
            }
        }else {
            new Exception(map+"is null!");
        }
        return array;
    }
    //json->map中的key 和 value 加入数组
    public Object [][] getDataProvider2 (Map<String,Object>map){

        Object array[][] = new Object[map.size()][2];
        if(map.size()!=0) {
            int i= 0;
            for(String key : map.keySet()) {
                array[i][0] =map.get(key);
                array[i][1] =key;
                i++;
            }
        }else {
            new Exception(map+"is null!");
        }
        return array;
    }

    public Object[][] getJsonprovider(Object obj[][]){
        return obj;
    }
}

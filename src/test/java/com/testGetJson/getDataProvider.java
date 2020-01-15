package com.testGetJson;

import java.util.Map;

public class getDataProvider {




    public Object[][] myDataProvider(Map<String,Object > map){
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

}

package com.htht.Fileutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class PaserJarray  {
    private static final String actions = "actions";
    private static final String setvalues = "setvalues";

    public  static List<ActionInit> getActions(JSONObject object){

        List<ActionInit> result = null;
        try {
            JSONArray jarray = object.getJSONArray(actions);
            result = JSON.parseArray(jarray.toJSONString(), ActionInit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object[][]getSetvlues(JSONObject object){
        Object result [][] =null;
        try {
            JSONArray jarray = object.getJSONArray(setvalues);
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
            return result;
    }



//    public static void main(String[] args) {
//        String readstr = ReadInstance.getInstance().getjsonfile("jsonfiles/caseData/weixingguance_Dat.json");
//        String readstr2 = ReadInstance.getInstance().getjsonfile("jsonfiles/caseElement/weixingguance_Ele.json");
//        JSONObject object = PaserJsonfile.getJobject(readstr);
//        JSONObject object2 =PaserJsonfile.getJobject(readstr2);
//        PaserJarray.getData(object,"卫星观测_caseData");
//        GetCases.getEle(object2,"卫星观测");
//    }

}

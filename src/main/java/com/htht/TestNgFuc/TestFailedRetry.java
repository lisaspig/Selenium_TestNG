package com.htht.TestNgFuc;

import com.htht.Fileutil.PropertiesInit;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class TestFailedRetry implements IRetryAnalyzer {


    @Override
    public boolean retry(ITestResult result){
        int count = 1;
        String retrycont = PropertiesInit.getRetrycont();
//      String maxRetryCount = PropertiesInit.getRetrycont();
        int max;
        System.out.println("retrycont+++++++++++++++++++++++++++"+retrycont);
        if(retrycont==null) {
            max = 2;
        }else{
            max = Integer.valueOf(retrycont);
            }
        if(count <= max){
            result.setAttribute("RETRY",count);
            count++;
            return true;
        }
        return false;
    }
}

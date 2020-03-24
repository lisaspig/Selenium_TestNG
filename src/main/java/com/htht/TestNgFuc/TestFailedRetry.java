package com.htht.TestNgFuc;

import com.htht.Fileutil.PropertiesInit;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class TestFailedRetry implements IRetryAnalyzer {
    private static String retrycont = PropertiesInit.getRetrycont();
    private int count = 1;
    @Override
    public boolean retry(ITestResult result){
//       String maxRetryCount = PropertiesInit.getRetrycont();
        int max;
        System.out.println("test+++++++++++++++++++++++++++"+retrycont);
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

package com.TestNgFuc;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class failedRetry implements IRetryAnalyzer {
    private  int count = 1;
    private String maxRetryCount =testBate.getConf().getProperty("retrycont");
    @Override
    public boolean retry(ITestResult result){
        int max = Integer.valueOf(this.maxRetryCount);
        if(count <= max){
            result.setAttribute("RETRY",count);
            count++;
            return true;
        }
        return false;
    }
}

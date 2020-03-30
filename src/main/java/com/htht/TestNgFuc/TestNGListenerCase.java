package com.htht.TestNgFuc;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.*;


    public class TestNGListenerCase implements ITestNGListener{

        //测试开始前执行
        public void onStart(ITestContext context) {

        }
        //测试结束后执行
        public void onFinish(ITestContext context) {

        }
        //测试成功率满足SuccessPercentage条件时执行
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        }
        //测试错误后执行
        public void	onTestFailure(ITestResult result) {

        }
        //测试跳过后执行
        public void onTestSkipped(ITestResult result) {

        }
        //测试成功后执行
        public void onTestSuccess(ITestResult result) {

        }
}

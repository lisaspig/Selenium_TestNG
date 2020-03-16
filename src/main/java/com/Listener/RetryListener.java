package com.Listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.IRetryAnalyzer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import com.TestNgFuc.failedRetry;

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(failedRetry.class);
        }
    }
}

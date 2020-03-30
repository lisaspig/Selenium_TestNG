package com.htht.TestNgFuc;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.List;

public class CreatSuit {

    private String suitname;


    public void testsuit(XmlTest xmlTest, List<String> lisener,String parallel){
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setListeners(lisener);
        xmlSuite.setThreadCount(6);
        xmlSuite.setParallel(parallel);
        TestNG testNG = new TestNG();
    }

}

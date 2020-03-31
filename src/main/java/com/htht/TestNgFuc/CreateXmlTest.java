package com.htht.TestNgFuc;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlMethodSelector;
import org.testng.xml.XmlMethodSelectors;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class CreateXmlTest {

    public void addMathod(){

        XmlTest xmlTest = new XmlTest();
        xmlTest.setName("test");
        xmlTest.setParallel("test");
        XmlClass xmlClass = new XmlClass();
        XmlMethodSelector xmlMethodSelector = new XmlMethodSelector();
        xmlMethodSelector.setClassName("com.htht.CasesBase.ITestCase");
        List<String> incloudmethod = new ArrayList<>();
        incloudmethod.add("");
    }
}

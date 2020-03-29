package com.htht.SeleniumFuc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Set;

public class LocatElement {

        private WebDriver driver;
        private HashMap<String, HashMap<String, String>> hashMap;

        public LocatElement(WebDriver driver, HashMap<String, HashMap<String, String>> hashMap) {
            this.driver = driver;
            this.hashMap=hashMap;
        }


        public void setLocatorVariableValue(String variable, String value){
            Set<String> keys = hashMap.keySet();
            for(String key:keys){
                String v = hashMap.get(key).get("value").replaceAll("%"+variable+"%", value);
                hashMap.get(key).put("value",v);
            }
        }

        private String getLocatorString(String locatorString, String[] ss) {
            for (String s : ss) {
                locatorString = locatorString.replaceFirst("%s", s);
            }
            return locatorString;
        }

        private By getBy(String type, String value) {
            By by = null;
            if (type.equals("id")) {
                by = By.id(value);
            }
            if (type.equals("name")) {
                by = By.name(value);
            }
            if (type.equals("xpath")) {
                by = By.xpath(value);
            }
            if (type.equals("className")) {
                by = By.className(value);
            }
            if (type.equals("linkText")) {
                by = By.linkText(value);
            }
            return by;
        }

        private WebElement watiForElement(final By by,String timeout) {
            WebElement element = null;
            int waitTime = Integer.parseInt(timeout);
            try {
                element = new WebDriverWait(driver, waitTime)
                        .until(new ExpectedCondition<WebElement>() {
                            public WebElement apply(WebDriver d) {
                                return d.findElement(by);
                            }
                        });
            } catch (Exception e) {
                System.out.println(by.toString() + " is not exist until " + waitTime);
            }
            return element;
        }

        private boolean waitElementToBeDisplayed(final WebElement element,String timeout) {
            boolean wait = false;
            if (element == null)
                return wait;
            try {
                wait = new WebDriverWait(driver, Integer.parseInt(timeout))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                return element.isDisplayed();
                            }
                        });
            } catch (Exception e) {
                System.out.println(element.toString() + " is not displayed");
            }
            return wait;
        }

        public boolean waitElementToBeNonDisplayed(final WebElement element,String timeout) {
            boolean wait = false;
            if (element == null)
                return wait;
            try {
                wait = new WebDriverWait(driver, Integer.parseInt(timeout))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                return !element.isDisplayed();
                            }
                        });
            } catch (Exception e) {
                System.out.println("Locator [" + element.toString()
                        + "] is also displayed");
            }
            return wait;
        }

        private WebElement getLocator(String key, String[] replace, boolean wait) {
            WebElement element = null;
            if (hashMap.containsKey(key)) {
                HashMap<String, String> m = hashMap.get(key);
                String type = m.get("type");
                String value = m.get("value");
                String timeout =m.get("timeout");
                if (replace != null) {
                    value = this.getLocatorString(value, replace);
                }
                By by = this.getBy(type, value);
                if (wait) {
                    element = this.watiForElement(by, timeout);
                    boolean flag = this.waitElementToBeDisplayed(element, timeout);
                    if (!flag) {
                        element = null;
                    }
                } else {
                    try {
                        element = driver.findElement(by);
                    } catch (Exception e) {
                        element = null;
                    }
                }
            } else {
                    System.out.println("Locator " + key + " is not exist in ");
                }
            return element;
        }

        public WebElement getElement(String key) {
            return this.getLocator(key, null, true);
        }

        public WebElement getElementNoWait(String key) {
            return this.getLocator(key, null, false);
        }

        public WebElement getElement(String key, String[] replace) {
            return this.getLocator(key, replace, true);
        }

        public WebElement getElementNoWait(String key, String[] replace) {
            return this.getLocator(key, replace, false);
        }
}


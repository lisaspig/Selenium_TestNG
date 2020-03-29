package com.htht.Fileutil;

public class PropertiesInit {

    private static String reportpath;
    private static String dirverpath;
    private static String logpath;
    private static String imagepath;
    private static String isremot;
    private static String retrycont;
    private static String remothub;

    public static String getRemothub() {
        return remothub;
    }

    public static void setRemothub(String remothub) {
        PropertiesInit.remothub = remothub;
    }

    public static String getReportpath() {
        return reportpath;
    }

    public static void setReportpath(String reportpath) {
        PropertiesInit.reportpath = reportpath;
    }

    public static String getDirverpath() {
        return dirverpath;
    }

    public static void setDirverpath(String dirverpath) {
        PropertiesInit.dirverpath = dirverpath;
    }

    public static String getLogpath() {
        return logpath;
    }

    public static void setLogpath(String logpath) {
        PropertiesInit.logpath = logpath;
    }

    public static String getImagepath() {
        return imagepath;
    }

    public static void setImagepath(String imagepath) {
        PropertiesInit.imagepath = imagepath;
    }

    public static String getIsremot() {
        return isremot;
    }

    public static void setIsremot(String isremot) {
        PropertiesInit.isremot = isremot;
    }

    public static String getRetrycont() {
        return retrycont;
    }

    public static void setRetrycont(String retrycont) {
        PropertiesInit.retrycont = retrycont;
    }
}

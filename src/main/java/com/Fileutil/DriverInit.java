package com.Fileutil;

public class DriverInit {

    private String drivertype;
    private String driverpath;
    private String platform;
    private String remotUrl;
    private String reportpath;
    private String logpath;
    private String imagepath;

    public DriverInit(String drivertype, String driverpath, String platform, String remotUrl, String reportpath, String logpath, String imagepath) {
        this.drivertype = drivertype;
        this.driverpath = driverpath;
        this.platform = platform;
        this.remotUrl = remotUrl;
        this.reportpath = reportpath;
        this.logpath = logpath;
        this.imagepath = imagepath;
    }

    public String getDrivertype() {
        return drivertype;
    }

    public void setDrivertype(String drivertype) {
        this.drivertype = drivertype;
    }

    public String getDriverpath() {
        return driverpath;
    }

    public void setDriverpath(String driverpath) {
        this.driverpath = driverpath;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRemotUrl() {
        return remotUrl;
    }

    public void setRemotUrl(String remotUrl) {
        this.remotUrl = remotUrl;
    }

    public String getReportpath() {
        return reportpath;
    }

    public void setReportpath(String reportpath) {
        this.reportpath = reportpath;
    }

    public String getLogpath() {
        return logpath;
    }

    public void setLogpath(String logpath) {
        this.logpath = logpath;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}

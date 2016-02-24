package com.waterwood.entity;

import java.util.Date;

public class Logistics {
    private Integer logisticsId;

    private String qrcodeOutsidecode;

    private String logisticsStation;

    private String logisticsCity;

    private String logisticsStatus;

    private String logisticsType;

    private String logisticsInfo;

    private Date logisticsCreatetime;

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getQrcodeOutsidecode() {
        return qrcodeOutsidecode;
    }

    public void setQrcodeOutsidecode(String qrcodeOutsidecode) {
        this.qrcodeOutsidecode = qrcodeOutsidecode == null ? null : qrcodeOutsidecode.trim();
    }

    public String getLogisticsStation() {
        return logisticsStation;
    }

    public void setLogisticsStation(String logisticsStation) {
        this.logisticsStation = logisticsStation == null ? null : logisticsStation.trim();
    }

    public String getLogisticsCity() {
        return logisticsCity;
    }

    public void setLogisticsCity(String logisticsCity) {
        this.logisticsCity = logisticsCity == null ? null : logisticsCity.trim();
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus == null ? null : logisticsStatus.trim();
    }

    public String getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(String logisticsType) {
        this.logisticsType = logisticsType == null ? null : logisticsType.trim();
    }

    public String getLogisticsInfo() {
        return logisticsInfo;
    }

    public void setLogisticsInfo(String logisticsInfo) {
        this.logisticsInfo = logisticsInfo == null ? null : logisticsInfo.trim();
    }

    public Date getLogisticsCreatetime() {
        return logisticsCreatetime;
    }

    public void setLogisticsCreatetime(Date logisticsCreatetime) {
        this.logisticsCreatetime = logisticsCreatetime;
    }
}
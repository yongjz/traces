package com.waterwood.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MerchandisePatch {
    private Integer merchandisepatchId;

    private String merchandisepatchCode;

    private String merchandiseName;

    private String merchandisepatchInfo;

    private Integer merchandiseCount;

    private Date merchandisepatchProductingdate;

    private String merchandisepatchProductingarea;

    private Date merchandiseShelflife;

    private Long merchandisepatchMinprice;

    private Long merchandisepatchMaxprice;

    private String acceptanceauthorityCode;

    private String merchandisepatchCatalogcode;

    private String merchandisepatchBuyercode;

    private String merchandisepatchPro;

    private Date merchandisepatchCreatetime;

    public Integer getMerchandisepatchId() {
        return merchandisepatchId;
    }

    public void setMerchandisepatchId(Integer merchandisepatchId) {
        this.merchandisepatchId = merchandisepatchId;
    }

    public String getMerchandisepatchCode() {
        return merchandisepatchCode;
    }

    public void setMerchandisepatchCode(String merchandisepatchCode) {
        this.merchandisepatchCode = merchandisepatchCode == null ? null : merchandisepatchCode.trim();
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName == null ? null : merchandiseName.trim();
    }

    public String getMerchandisepatchInfo() {
        return merchandisepatchInfo;
    }

    public void setMerchandisepatchInfo(String merchandisepatchInfo) {
        this.merchandisepatchInfo = merchandisepatchInfo == null ? null : merchandisepatchInfo.trim();
    }

    public Integer getMerchandiseCount() {
        return merchandiseCount;
    }

    public void setMerchandiseCount(Integer merchandiseCount) {
        this.merchandiseCount = merchandiseCount;
    }

    public Date getMerchandisepatchProductingdate() {
        return merchandisepatchProductingdate;
    }

    public void setMerchandisepatchProductingdate(Date merchandisepatchProductingdate) {
        this.merchandisepatchProductingdate = merchandisepatchProductingdate;
    }

    public String getMerchandisepatchProductingarea() {
        return merchandisepatchProductingarea;
    }

    public void setMerchandisepatchProductingarea(String merchandisepatchProductingarea) {
        this.merchandisepatchProductingarea = merchandisepatchProductingarea == null ? null : merchandisepatchProductingarea.trim();
    }

    public Date getMerchandiseShelflife() {
        return merchandiseShelflife;
    }

    public void setMerchandiseShelflife(Date merchandiseShelflife) {
        this.merchandiseShelflife = merchandiseShelflife;
    }

    public Long getMerchandisepatchMinprice() {
        return merchandisepatchMinprice;
    }

    public void setMerchandisepatchMinprice(Long merchandisepatchMinprice) {
        this.merchandisepatchMinprice = merchandisepatchMinprice;
    }

    public Long getMerchandisepatchMaxprice() {
        return merchandisepatchMaxprice;
    }

    public void setMerchandisepatchMaxprice(Long merchandisepatchMaxprice) {
        this.merchandisepatchMaxprice = merchandisepatchMaxprice;
    }

    public String getAcceptanceauthorityCode() {
        return acceptanceauthorityCode;
    }

    public void setAcceptanceauthorityCode(String acceptanceauthorityCode) {
        this.acceptanceauthorityCode = acceptanceauthorityCode == null ? null : acceptanceauthorityCode.trim();
    }

    public String getMerchandisepatchCatalogcode() {
        return merchandisepatchCatalogcode;
    }

    public void setMerchandisepatchCatalogcode(String merchandisepatchCatalogcode) {
        this.merchandisepatchCatalogcode = merchandisepatchCatalogcode == null ? null : merchandisepatchCatalogcode.trim();
    }

    public String getMerchandisepatchBuyercode() {
        return merchandisepatchBuyercode;
    }

    public void setMerchandisepatchBuyercode(String merchandisepatchBuyercode) {
        this.merchandisepatchBuyercode = merchandisepatchBuyercode == null ? null : merchandisepatchBuyercode.trim();
    }

    public String getMerchandisepatchPro() {
        return merchandisepatchPro;
    }

    public void setMerchandisepatchPro(String merchandisepatchPro) {
        this.merchandisepatchPro = merchandisepatchPro == null ? null : merchandisepatchPro.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getMerchandisepatchCreatetime() {
        return merchandisepatchCreatetime;
    }

    public void setMerchandisepatchCreatetime(Date merchandisepatchCreatetime) {
        this.merchandisepatchCreatetime = merchandisepatchCreatetime;
    }
}
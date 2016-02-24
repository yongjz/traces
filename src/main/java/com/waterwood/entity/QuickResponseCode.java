package com.waterwood.entity;

import java.util.Date;

public class QuickResponseCode {
    private Integer qrcodeId;

    private String qrcodeOutsidecode;

    private String qrcodeInsidecode;

    private String qrcodeInfo;

    private String qrcodeStatus;

    private String qrcodeType;

    private String qrcodeMerchandisecode;

    private String qrcodeMerchandisepatchcode;

    private String qrcodeOutsidesrc;

    private String qrcodeInsidesrc;

    private Date qrcodeCreatetime;

    private Date qrcodeUsertime;

    private String qrcodeSeller;

    public Integer getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(Integer qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    public String getQrcodeOutsidecode() {
        return qrcodeOutsidecode;
    }

    public void setQrcodeOutsidecode(String qrcodeOutsidecode) {
        this.qrcodeOutsidecode = qrcodeOutsidecode == null ? null : qrcodeOutsidecode.trim();
    }

    public String getQrcodeInsidecode() {
        return qrcodeInsidecode;
    }

    public void setQrcodeInsidecode(String qrcodeInsidecode) {
        this.qrcodeInsidecode = qrcodeInsidecode == null ? null : qrcodeInsidecode.trim();
    }

    public String getQrcodeInfo() {
        return qrcodeInfo;
    }

    public void setQrcodeInfo(String qrcodeInfo) {
        this.qrcodeInfo = qrcodeInfo == null ? null : qrcodeInfo.trim();
    }

    public String getQrcodeStatus() {
        return qrcodeStatus;
    }

    public void setQrcodeStatus(String qrcodeStatus) {
        this.qrcodeStatus = qrcodeStatus == null ? null : qrcodeStatus.trim();
    }

    public String getQrcodeType() {
        return qrcodeType;
    }

    public void setQrcodeType(String qrcodeType) {
        this.qrcodeType = qrcodeType == null ? null : qrcodeType.trim();
    }

    public String getQrcodeMerchandisecode() {
        return qrcodeMerchandisecode;
    }

    public void setQrcodeMerchandisecode(String qrcodeMerchandisecode) {
        this.qrcodeMerchandisecode = qrcodeMerchandisecode == null ? null : qrcodeMerchandisecode.trim();
    }

    public String getQrcodeMerchandisepatchcode() {
        return qrcodeMerchandisepatchcode;
    }

    public void setQrcodeMerchandisepatchcode(String qrcodeMerchandisepatchcode) {
        this.qrcodeMerchandisepatchcode = qrcodeMerchandisepatchcode == null ? null : qrcodeMerchandisepatchcode.trim();
    }

    public String getQrcodeOutsidesrc() {
        return qrcodeOutsidesrc;
    }

    public void setQrcodeOutsidesrc(String qrcodeOutsidesrc) {
        this.qrcodeOutsidesrc = qrcodeOutsidesrc == null ? null : qrcodeOutsidesrc.trim();
    }

    public String getQrcodeInsidesrc() {
        return qrcodeInsidesrc;
    }

    public void setQrcodeInsidesrc(String qrcodeInsidesrc) {
        this.qrcodeInsidesrc = qrcodeInsidesrc == null ? null : qrcodeInsidesrc.trim();
    }

    public Date getQrcodeCreatetime() {
        return qrcodeCreatetime;
    }

    public void setQrcodeCreatetime(Date qrcodeCreatetime) {
        this.qrcodeCreatetime = qrcodeCreatetime;
    }

    public Date getQrcodeUsertime() {
        return qrcodeUsertime;
    }

    public void setQrcodeUsertime(Date qrcodeUsertime) {
        this.qrcodeUsertime = qrcodeUsertime;
    }

    public String getQrcodeSeller() {
        return qrcodeSeller;
    }

    public void setQrcodeSeller(String qrcodeSeller) {
        this.qrcodeSeller = qrcodeSeller == null ? null : qrcodeSeller.trim();
    }
}
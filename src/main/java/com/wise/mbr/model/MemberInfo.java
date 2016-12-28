package com.wise.mbr.model;

import com.wise.comm.bean.Paging;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Project : cbt_web
 * Package : com.wise.mbr.model
 * FileName : MemberInfo
 * Date : 16. 12. 13
 * Author : nick@bluewisesoft.com
 * Description : write class description here
 */

@Entity(name = "tb_mbr_i")
public class MemberInfo extends Paging implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "mbr_no", nullable = false)
    private long mbrNo;

    @Column(name = "biz_num", nullable = false)
    private String bizNum;

    @Column(name = "usr_id", nullable = false)
    private String usrId;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    @Column(name = "co_nm", nullable = false)
    private String coNm;

    @Column(name = "rep_nm", nullable = false)
    private String repNm;

    @Column(name = "co_addr", nullable = false)
    private String coAddr;

    @Column(name = "co_detail_addr", nullable = false)
    private String coDetailAddr;

    @Column(name = "zip_cd", nullable = false)
    private String zipCd;

    @Column(name = "co_eng_addr", nullable = false)
    private String coEngAddr;

    @Column(name = "biz_plc_phone_num", nullable = false)
    private String bizPlcPhoneNum;

    @Column(name = "co_fax_num")
    private String coFaxNum;

    @Column(name = "co_url")
    private String coUrl;

    @Column(name = "manager_nm", nullable = false)
    private String managerNm;

    @Column(name = "manager_phone_num", nullable = false)
    private String managerPhoneNum;

    @Column(name = "manager_tel", nullable = false)
    private String managerTel;

    @Column(name = "manager_email", nullable = false)
    private String managerEmail;

    @Column(name = "registrant", nullable = false)
    private String registrant;

    @Column(name = "registrant_dtm", nullable = false)
    private Timestamp registrantDtm;

    public long getMbrNo() {
        return mbrNo;
    }

    public String getBizNum() {
        return bizNum;
    }

    public String getUsrId() {
        return usrId;
    }

    public String getPwd() {
        return pwd;
    }

    public String getCoNm() {
        return coNm;
    }

    public String getRepNm() {
        return repNm;
    }

    public String getCoAddr() {
        return coAddr;
    }

    public String getCoDetailAddr() {
        return coDetailAddr;
    }

    public String getZipCd() {
        return zipCd;
    }

    public String getCoEngAddr() {
        return coEngAddr;
    }

    public String getBizPlcPhoneNum() {
        return bizPlcPhoneNum;
    }

    public String getCoFaxNum() {
        return coFaxNum;
    }

    public String getCoUrl() {
        return coUrl;
    }

    public String getManagerNm() {
        return managerNm;
    }

    public String getManagerPhoneNum() {
        return managerPhoneNum;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public String getRegistrant() {
        return registrant;
    }

    public Timestamp getRegistrantDtm() {
        return registrantDtm;
    }

    public void setMbrNo(long mbrNo) {
        this.mbrNo = mbrNo;
    }

    public void setBizNum(String bizNum) {
        this.bizNum = bizNum;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setCoNm(String coNm) {
        this.coNm = coNm;
    }

    public void setRepNm(String repNm) {
        this.repNm = repNm;
    }

    public void setCoAddr(String coAddr) {
        this.coAddr = coAddr;
    }

    public void setCoDetailAddr(String coDetailAddr) {
        this.coDetailAddr = coDetailAddr;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public void setCoEngAddr(String coEngAddr) {
        this.coEngAddr = coEngAddr;
    }

    public void setBizPlcPhoneNum(String bizPlcPhoneNum) {
        this.bizPlcPhoneNum = bizPlcPhoneNum;
    }

    public void setCoFaxNum(String coFaxNum) {
        this.coFaxNum = coFaxNum;
    }

    public void setCoUrl(String coUrl) {
        this.coUrl = coUrl;
    }

    public void setManagerNm(String managerNm) {
        this.managerNm = managerNm;
    }

    public void setManagerPhoneNum(String managerPhoneNum) {
        this.managerPhoneNum = managerPhoneNum;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public void setRegistrantDtm(Timestamp registrantDtm) {
        this.registrantDtm = registrantDtm;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "mbrNo=" + mbrNo +
                ", bizNum='" + bizNum + '\'' +
                ", usrId='" + usrId + '\'' +
                ", coNm='" + coNm + '\'' +
                ", repNm='" + repNm + '\'' +
                ", coAddr='" + coAddr + '\'' +
                ", coDetailAddr='" + coDetailAddr + '\'' +
                ", zipCd='" + zipCd + '\'' +
                ", coEngAddr='" + coEngAddr + '\'' +
                ", bizPlcPhoneNum='" + bizPlcPhoneNum + '\'' +
                ", coFaxNum='" + coFaxNum + '\'' +
                ", coUrl='" + coUrl + '\'' +
                ", managerNm='" + managerNm + '\'' +
                ", managerPhoneNum='" + managerPhoneNum + '\'' +
                ", managerTel='" + managerTel + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", registrant='" + registrant + '\'' +
                ", registrantDtm=" + registrantDtm +
                '}';
    }
}

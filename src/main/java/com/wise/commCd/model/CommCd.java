package com.wise.commCd.model;

import com.wise.comm.bean.Paging;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Project : cbt.web
 * Package : com.wise.commCd.model
 * FileName : CommCd
 * Date : 16. 12. 12
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
/*@Entity(name = "tb_comm_cd")*/
public class CommCd extends Paging implements Serializable{

    @Id
    @Column(name = "comm_cd", unique=true, nullable=false)
    private String commCd;

    @Column(name = "sub_cd")
    private String subCd;

    @Column(name = "master_cd")
    private String masterCd;

    @Column(name = "cd_nm")
    private String cdNm;

    @Column(name = "cd_val")
    private String cdVal;

    @Column(name = "rqd_yn")
    private char rqdYn;

    @Column(name = "use_yn")
    private char useYn;

    @Column(name = "cd_desc")
    private String cdDesc;

    @Column(name = "registrant")
    private String registrant;

    @Column(name = "registrant_dtm")
    private Date registrantDtm;

    @Column(name = "modifier")
    private String modifier;

    @Column(name = "modified_dtm")
    private Date modifierDtm;

    @Column(name = "cd_usg_div")
    private String cdUsgDiv;


    public String getCommCd() {
        return commCd;
    }

    public void setCommCd(String commCd) {
        this.commCd = commCd;
    }

    public String getSubCd() {
        return subCd;
    }

    public void setSubCd(String subCd) {
        this.subCd = subCd;
    }

    public String getMasterCd() {
        return masterCd;
    }

    public void setMasterCd(String masterCd) {
        this.masterCd = masterCd;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCdVal() {
        return cdVal;
    }

    public void setCdVal(String cdVal) {
        this.cdVal = cdVal;
    }

    public char getRqdYn() {
        return rqdYn;
    }

    public void setRqdYn(char rqdYn) {
        this.rqdYn = rqdYn;
    }

    public char getUseYn() {
        return useYn;
    }

    public void setUseYn(char useYn) {
        this.useYn = useYn;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrantDtm() {
        return registrantDtm;
    }

    public void setRegistrantDtm(Date registrantDtm) {
        this.registrantDtm = registrantDtm;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifierDtm() {
        return modifierDtm;
    }

    public void setModifierDtm(Date modifierDtm) {
        this.modifierDtm = modifierDtm;
    }

    public String getCdUsgDiv() {
        return cdUsgDiv;
    }

    public void setCdUsgDiv(String cdUsgDiv) {
        this.cdUsgDiv = cdUsgDiv;
    }

    @Override
    public String toString() {
        return "CommCd{" +
                "commCd='" + commCd + '\'' +
                ", subCd='" + subCd + '\'' +
                ", masterCd='" + masterCd + '\'' +
                ", cdNm='" + cdNm + '\'' +
                ", cdVal='" + cdVal + '\'' +
                ", rqdYn='" + rqdYn + '\'' +
                ", useYn='" + useYn + '\'' +
                ", cdDesc='" + cdDesc + '\'' +
                ", registrant='" + registrant + '\'' +
                ", registrantDtm=" + registrantDtm +
                ", modifier='" + modifier + '\'' +
                ", modifierDtm=" + modifierDtm +
                ", cdUsgDiv='" + cdUsgDiv + '\'' +
                '}';
    }
}
package com.wise.mbr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Project : cbt_web
 * Package : com.wise.mbr.model
 * FileName : MbrTerms
 * Date : 16. 12. 14
 * Author : nick@bluewisesoft.com
 * Description : write class description here
 */
@Entity(name = "tb_mbr_terms_i")
public class MemberTermsInfo {

    @Id
    @Column(name = "term_cd")
    private String term_cd;

    @Column(name = "mbr_no")
    private long mbr_no;

    @Column(name = "agree_yn")
    private char agree_yn;

    @Column(name = "term_agree_dtm")
    private Timestamp term_agree_dtm;


    public String getTerm_cd() {
        return term_cd;
    }

    public void setTerm_cd(String term_cd) {
        this.term_cd = term_cd;
    }

    public long getMbr_no() {
        return mbr_no;
    }

    public void setMbr_no(long mbr_no) {
        this.mbr_no = mbr_no;
    }

    public char getAgree_yn() {
        return agree_yn;
    }

    public void setAgree_yn(char agree_yn) {
        this.agree_yn = agree_yn;
    }

    public Timestamp getTerm_agree_dtm() {
        return term_agree_dtm;
    }

    public void setTerm_agree_dtm(Timestamp term_agree_dtm) {
        this.term_agree_dtm = term_agree_dtm;
    }

    @Override
    public String toString() {
        return "MemberTermsInfo{" +
                "term_cd='" + term_cd + '\'' +
                ", mbr_no=" + mbr_no +
                ", agree_yn=" + agree_yn +
                ", term_agree_dtm=" + term_agree_dtm +
                '}';
    }
}

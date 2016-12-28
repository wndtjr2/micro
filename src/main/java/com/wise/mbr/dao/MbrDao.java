package com.wise.mbr.dao;

import com.wise.commCd.model.CommCd;
import com.wise.mbr.model.MemberInfo;
import com.wise.mbr.model.MemberTermsInfo;

import java.util.List;


/**
 * Project : cbt_web
 * Package : com.wise.mbr.dao
 * FileName : MbrDao
 * Date : 16. 12. 13
 * Author : nick@bluewisesoft.com
 * Description : write class description here
 */
public interface MbrDao {

    long mbrCreate(MemberInfo memberInfo);
    void mbrTermsCreate(MemberTermsInfo memberTermsInfo);
    MemberInfo memberInfoRead(MemberInfo memberInfo);
    List<CommCd> commCdList(CommCd commCd);
    void updatePwd(MemberInfo memberInfo);
    MemberInfo getMemberByUserId(String usrId);
    MemberInfo getMemberByBizNum(String bizNum);
    MemberInfo getMemberByMgrEmail(String managerEmail);

}

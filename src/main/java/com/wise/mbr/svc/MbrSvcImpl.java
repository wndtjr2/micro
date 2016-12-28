package com.wise.mbr.svc;

import com.wise.commCd.model.CommCd;
import com.wise.mbr.dao.MbrDao;
import com.wise.mbr.model.MemberInfo;
import com.wise.mbr.model.MemberTermsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : cbt_web
 * Package : com.wise.mbr.svc
 * FileName : MbrSvcImpl
 * Date : 16. 12. 13
 * Author : nick@bluewisesoft.com
 * Description : write class description here
 */

@Service
public class MbrSvcImpl implements MbrSvc {

    @Autowired
    private MbrDao mbrDao;

    @Override
    public long mbrCreate(MemberInfo memberInfo) {
        return mbrDao.mbrCreate(memberInfo);
    }

    @Override
    public void mbrTermsCreate(MemberTermsInfo memberTermsInfo) {
        mbrDao.mbrTermsCreate(memberTermsInfo);
    }

    @Override
    public List<CommCd> commCdList(CommCd commCd) {
        return mbrDao.commCdList(commCd);
    }

    @Override
    public void updatePwd(MemberInfo memberInfo) {
        mbrDao.updatePwd(memberInfo);
    }

    @Override
    public MemberInfo getMemberByUserId(String usrId){
        return mbrDao.getMemberByUserId(usrId);
    }

    @Override
    public MemberInfo readMemberByMbrNo(MemberInfo memberInfo){
        return mbrDao.memberInfoRead(memberInfo);
    }

    @Override
    public MemberInfo getMemberByBizNum(String bizNum) {
        return mbrDao.getMemberByBizNum(bizNum);
    }

    @Override
    public MemberInfo getMemberByMgrEmail(String managerEmail) {
        return mbrDao.getMemberByMgrEmail(managerEmail);
    }
}

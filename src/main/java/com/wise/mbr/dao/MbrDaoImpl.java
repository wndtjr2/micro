package com.wise.mbr.dao;

import com.wise.commCd.model.CommCd;
import com.wise.mbr.model.MemberInfo;
import com.wise.mbr.model.MemberTermsInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Project : cbt_web
 * Package : com.wise.mbr.dao
 * FileName : MbrDaoImpl
 * Date : 16. 12. 13
 * Author : nick@bluewisesoft.com
 * Description : write class description here
 */
@Repository
@Transactional
public class MbrDaoImpl implements MbrDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public long mbrCreate(MemberInfo memberInfo) {

        manager.persist(memberInfo);
        manager.flush();

        return memberInfo.getMbrNo();
    }

    @Override
    public void mbrTermsCreate(MemberTermsInfo memberTermsInfo) {

        manager.persist(memberTermsInfo);
    }

    @Override
    public MemberInfo memberInfoRead(MemberInfo memberInfo) {

        MemberInfo memberInfoRead = manager.find(MemberInfo.class, memberInfo.getMbrNo());
        return memberInfoRead;
    }

    @Override
    public List<CommCd> commCdList(CommCd commCd) {
        Query query = manager.createQuery("from tb_comm_cd where comm_cd=:commCd", CommCd.class);

        query.setParameter("commCd" , commCd.getCommCd());
        List<CommCd> commCdList = query.getResultList();

        return commCdList;
    }


    @Override
    public void updatePwd(MemberInfo memberInfo) {
        manager.merge(memberInfo);
    }

    @Override
    public MemberInfo getMemberByUserId(String usrId){

        String sqlStr = "from tb_mbr_i where usr_id=:usrId";
        Query query = manager.createQuery(sqlStr, MemberInfo.class);
        query.setParameter("usrId", usrId);
        System.out.println("=======>? query " + query);
        System.out.println(" user id  : " +  usrId);
        MemberInfo memberInfoOutVo = (MemberInfo) query.getSingleResult();

        return memberInfoOutVo;
    }

    @Override
    public MemberInfo getMemberByBizNum(String bizNum) {
        String sqlStr = "from tb_mbr_i where biz_num=:bizNum";
        Query query = manager.createQuery(sqlStr, MemberInfo.class);
        query.setParameter("bizNum", bizNum);
        MemberInfo memberInfoOutVo = (MemberInfo) query.getSingleResult();

        return memberInfoOutVo;
    }

    @Override
    public MemberInfo getMemberByMgrEmail(String managerEmail) {
        String sqlStr = "from tb_mbr_i where manager_email=:managerEmail";
        Query query = manager.createQuery(sqlStr, MemberInfo.class);
        query.setParameter("managerEmail", managerEmail);
        MemberInfo memberInfoOutVo = (MemberInfo) query.getSingleResult();

        return memberInfoOutVo;
    }
}

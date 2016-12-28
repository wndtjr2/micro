package com.wise.commCd.dao;

import com.wise.commCd.model.CommCd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Project : cbt.web
 * Package : com.wise.commCd.dao
 * FileName : CommCdDaoImpl
 * Date : 16. 12. 12
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Repository
@Transactional
public class CommCdDaoImpl implements CommCdDao {

    private Logger logger = LoggerFactory.getLogger(CommCdDaoImpl.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void saveCommCd(CommCd commCd) {
        manager.persist(commCd);
    }

    @Override
    public int commCdTotal() {
        Query query = manager.createQuery("from tb_comm_cd", CommCd.class);
        int rowCnt = query.getResultList().size();

        return rowCnt;
    }

    @Override
    public List<CommCd> listCommCd(CommCd commCd) {
        Query query = manager.createQuery("from tb_comm_cd", CommCd.class);
        query.setFirstResult(commCd.getPageNo());
        query.setMaxResults(commCd.getPageSize());

        System.out.println("pNO ::::: " + commCd.getPageNo());
        System.out.println("pSize :::: " + commCd.getPageSize());
        List<CommCd> commCdList = query.getResultList();

        for(CommCd logCommCd : commCdList){
            System.out.println("TEST NYG : ::::::: " + logCommCd.getCommCd());
        }

        return commCdList;
    }

    @Override
    public CommCd commCdFind(CommCd commCdv) {
        CommCd commCd = manager.find(CommCd.class, commCdv.getCommCd());

        return commCd;
    }

    @Override
    public void commCdUpdate(CommCd commCd) {
        manager.merge(commCd);
    }

    @Override
    public void deleteCommCd(CommCd commCd) {
        commCd = manager.merge(commCd);
        manager.remove(commCd);
    }
}
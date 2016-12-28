package com.wise.commCd.svc;

import com.wise.commCd.dao.CommCdDao;
import com.wise.commCd.model.CommCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : cbt.web
 * Package : com.wise.commCd.svc
 * FileName : CommCdSvcImpl
 * Date : 16. 12. 12
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Service
public class CommCdSvcImpl implements CommCdSvc {

    @Autowired
    private CommCdDao commCdDao;

    @Override
    public void saveCommCd(CommCd commCd) {
        commCdDao.saveCommCd(commCd);
    }

    @Override
    public List<CommCd> listCommCd(CommCd commCd) {
        commCd.setPageNo(commCd.getPageNo());
        commCd.setPageSize(commCd.getPageSize());
        commCd.setTotalCount(commCdDao.commCdTotal());
        commCd.setPageNo(commCd.getPageNo());
        System.out.println("total = "+commCdDao.commCdTotal());
        return commCdDao.listCommCd(commCd);
    }


    @Override
    public CommCd commCdFind(CommCd commCd) {
        return commCdDao.commCdFind(commCd);
    }

    public void setCommCdDao(CommCdDao commCdDao) {
        this.commCdDao = commCdDao;
    }

    @Override
    public void commCdUpdate(CommCd commCd) {
        commCdDao.commCdUpdate(commCd);
    }

    @Override
    public void deleteCommCd(CommCd commCd) {
        commCdDao.deleteCommCd(commCd);
    }
}
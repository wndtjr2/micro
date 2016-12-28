package com.wise.csv.dao;

import com.wise.csv.model.eBaySaleHd;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.api.t.dao
 * FileName : EbayDaoImpl
 * Date : 16. 12. 5
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Repository
@Transactional
public class ebaySaleHdDaoImpl implements ebaySaleHdDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public eBaySaleHd findBySalesRecordNumber(String salesRecordNumber) {
        eBaySaleHd hd = manager.find(eBaySaleHd.class, salesRecordNumber);
        return hd;
    }

    @Override
    public eBaySaleHd findBySalesTransactionId(String transactionId, String itemId, String salesRecordNumber) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<eBaySaleHd> criteriaQuery = criteriaBuilder.createQuery(eBaySaleHd.class);
        Root<eBaySaleHd> root = criteriaQuery.from(eBaySaleHd.class);

        Predicate restrictions = criteriaBuilder.equal(root.get("transactionId"), transactionId);
        Predicate restrictions2 = criteriaBuilder.equal(root.get("itemId"), itemId);
        Predicate restrictions3 = criteriaBuilder.equal(root.get("salesRecordNumber"), salesRecordNumber);
        criteriaQuery.where(restrictions, restrictions2, restrictions3);

        TypedQuery<eBaySaleHd> hdQuery = manager.createQuery(criteriaQuery);

        return hdQuery.getSingleResult();
    }

    @Override
    public void createEbay(eBaySaleHd eBaySaleHd) {
        manager.persist(eBaySaleHd);
    }

    @Override
    public List<eBaySaleHd> listEbay() {
        Query query = manager.createQuery("from tb_ebay_sale_hd", eBaySaleHd.class);

        return query.getResultList();
    }

    @Override
    public void createEbayHmHd(List<eBaySaleHd> eBaySaleHds) {
        for (eBaySaleHd eBaySaleHd : eBaySaleHds) {
            manager.persist(eBaySaleHd);
        }
    }
}
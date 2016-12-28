package com.wise.csv.dao;

import com.wise.csv.model.eBaySaleHm;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

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
public class ebaySaleHmDaoImpl implements ebaySaleHmDao{

    @PersistenceContext
    EntityManager manager;

    @Override
    public eBaySaleHm findBysalesRecordNumber(String salesRecordNumber) {
        eBaySaleHm hm = manager.find(eBaySaleHm.class, salesRecordNumber);
        return hm;
    }

    @Override
    public eBaySaleHm findBySRNUsrid(String salesRecordNumber, String usrid) {
        Query query = manager.createQuery("from tb_ebay_sale_hm where sales_record_number =:salesRecordNumber and cbt_user_id=:cbtUserId", eBaySaleHm.class);
        query.setParameter("salesRecordNumber",salesRecordNumber);
        query.setParameter("cbtUserId" , usrid);

        return (eBaySaleHm) query.getSingleResult();
    }

    @Override
    public void createEbay(eBaySaleHm eBaySaleHm) {
        manager.persist(eBaySaleHm);
    }

    @Override
    public List<eBaySaleHm> listEbay(String usrid) {
        Query query = manager.createQuery("from tb_ebay_sale_hm where cbt_user_id=:cbtUserId", eBaySaleHm.class);
        query.setParameter("cbtUserId",usrid);
        return query.getResultList();
    }

    @Override
    public void createEbaySaleHm(List<eBaySaleHm> eBaySaleHms) {
        for (eBaySaleHm eBaySaleHm : eBaySaleHms){
            manager.persist(eBaySaleHm);
        }
    }

    @Override
    public List<eBaySaleHm> findByUserId(String usrid){
        Query query = manager.createQuery("from tb_ebay_sale_hm where cbt_user_id=:cbtUserId", eBaySaleHm.class);
        query.setParameter("cbtUserId" , usrid);
        return query.getResultList();
    }

    @Override
    public List<eBaySaleHm> findByUserIdWithDate(String usrid, String dtFrom, String dtTo) {
        Query query = manager.createQuery("from tb_ebay_sale_hm " +
                "where cbt_user_id=:cbtUserId and STR_TO_DATE(sale_date, '%M-%d-%Y')\n" +
                "BETWEEN STR_TO_DATE(:dateFrom, '%M-%d-%Y')\n" +
                "AND STR_TO_DATE(:dateTo, '%M-%d-%Y')", eBaySaleHm.class);
        System.out.println("query : "+query);
        query.setParameter("cbtUserId" , usrid);
        query.setParameter("dateFrom" , dtFrom);
        query.setParameter("dateTo" , dtTo);
        System.out.println("==================================>Query : "+query);
        return query.getResultList();

    }

    @Override
    public List<eBaySaleHm> findByUserIdWithWhere(String usrid, Map<String, String> where) {

        String sqlStr = "from tb_ebay_sale_hm where cbt_user_id=:cbtUserId ";
        if (where.get("buyerState")!=null && !where.get("buyerState").isEmpty()){
            sqlStr += " and buyer_state = :buyerState ";
        }
        if (where.get("paymentMethod")!=null && !where.get("paymentMethod").isEmpty()){
            sqlStr += " and payment_method= :paymentMethod ";
        }
        if (where.get("startD")!=null && !where.get("startD").isEmpty()){
            sqlStr += " and sale_date_db >= :startD ";
        }
        if (where.get("endD")!=null && !where.get("endD").isEmpty()){
            sqlStr += " and sale_date_db <= :endD ";
        }

        Query query = manager.createQuery(sqlStr, eBaySaleHm.class);
        query.setParameter("cbtUserId" , usrid);

        if (where.get("buyerState")!=null && !where.get("buyerState").isEmpty()){
            query.setParameter("buyerState" , where.get("buyerState"));
        }
        if (where.get("paymentMethod")!=null && !where.get("paymentMethod").isEmpty()){
            query.setParameter("paymentMethod" , where.get("paymentMethod"));
        }
        if (where.get("startD")!=null && !where.get("startD").isEmpty()){
            query.setParameter("startD" , where.get("startD"));
        }
        if (where.get("endD")!=null && !where.get("endD").isEmpty()){
            query.setParameter("endD" , where.get("endD"));
        }

        return query.getResultList();
    }
}
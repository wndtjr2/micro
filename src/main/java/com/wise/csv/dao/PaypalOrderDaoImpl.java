package com.wise.csv.dao;

import com.wise.csv.model.PaypalOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.dao
 * FileName : PaypalOrderDaoImpl
 * Date : 16. 12. 6
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Repository
@Transactional
public class PaypalOrderDaoImpl implements PaypalOrderDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void savePaypalOder(PaypalOrder paypalOrder) {
        manager.persist(paypalOrder);
    }

    @Override
    public void deletePaypalOder(PaypalOrder paypalOrder) {
        manager.remove(paypalOrder);
    }

    @Override
    public List<PaypalOrder> findAllPaypalOder(String usrId) {
        Query query = manager.createQuery("from tb_paypal_orders_csv where cbt_user_id=:cbtUserId", PaypalOrder.class);
        query.setParameter("cbtUserId" , usrId);
        return query.getResultList();
    }

    @Override
    public PaypalOrder findUsrByTxnid(String transactionId) {
        PaypalOrder paypalOrder = manager.find(PaypalOrder.class, transactionId);
        return paypalOrder;
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrId(String usrId){
        Query query = manager.createQuery("from tb_paypal_orders_csv where cbt_user_id=:cbtUserId and net > 0", PaypalOrder.class);
        System.out.println("query : "+query);
        query.setParameter("cbtUserId" , usrId);
        return query.getResultList();
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrIdAndDate(String usrId, String dateFrom, String dateTo){
        Query query = manager.createQuery("from tb_paypal_orders_csv " +
                "where cbt_user_id=:cbtUserId and net > 0 and STR_TO_DATE(date, '%m/%d/%Y')\n" +
                "BETWEEN STR_TO_DATE(:dateFrom, '%m/%d/%Y')\n" +
                "AND STR_TO_DATE(:dateTo, '%m/%d/%Y')", PaypalOrder.class);
        System.out.println("query : "+query);
        query.setParameter("cbtUserId" , usrId);
        query.setParameter("dateFrom" , dateFrom);
        query.setParameter("dateTo" , dateTo);
        return query.getResultList();
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrIdAndWhere(String usrId, Map<String, String> where) {

        String sqlStr = "from tb_paypal_orders_csv where cbt_user_id=:cbtUserId and net > 0";

        if (where.get("transactionId")!=null && !where.get("transactionId").isEmpty()){
            sqlStr += " and transactionId=:transactionId ";
        }
        if (where.get("dateFrom")!=null && !where.get("dateFrom").isEmpty()){
            sqlStr += " and date >= :dateFrom ";
        }
        if (where.get("dateTo")!=null && !where.get("dateTo").isEmpty()){
            sqlStr += " and date <= :dateTo ";
        }
        if (where.get("currency")!=null && !where.get("currency").isEmpty()){
            sqlStr += " and currency= :currency ";
        }

        Query query = manager.createQuery(sqlStr, PaypalOrder.class);

        query.setParameter("cbtUserId", usrId);

        if (where.get("transactionId")!=null && !where.get("transactionId").isEmpty()){
            query.setParameter("transactionId", where.get("transactionId"));
        }
        if (where.get("dateFrom")!=null && !where.get("dateFrom").isEmpty()){
            query.setParameter("dateFrom", where.get("dateFrom"));
        }
        if (where.get("dateTo")!=null && !where.get("dateTo").isEmpty()){
            query.setParameter("dateTo", where.get("dateTo"));
        }
        if (where.get("currency")!=null && !where.get("currency").isEmpty()){
            query.setParameter("currency", where.get("currency"));
        }

        return query.getResultList();
    }
}
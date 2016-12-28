package com.wise.csv.dao;

import com.wise.csv.model.PaypalOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by wisecommerce on 16. 12. 6.
 */
public interface PaypalOrderDao {
    void savePaypalOder(PaypalOrder paypalOrder);

    void deletePaypalOder(PaypalOrder paypalOrder);

    List<PaypalOrder> findAllPaypalOder(String usrId);

    PaypalOrder findUsrByTxnid(String txnid);

    List<PaypalOrder> findPaypalByUsrId(String usrId);

    List<PaypalOrder> findPaypalByUsrIdAndDate(String usrId, String dateFrom, String dateTo);

    List<PaypalOrder> findPaypalByUsrIdAndWhere(String usrId, Map<String, String> where);
}

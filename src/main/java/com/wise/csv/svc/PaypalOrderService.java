package com.wise.csv.svc;

import com.wise.csv.model.PaypalOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by wisecommerce on 16. 12. 6.
 */
public interface PaypalOrderService {
    void savePaypalOder(PaypalOrder paypalOrder);

    void updatePaypalOder(PaypalOrder paypalOrder);

    void deletePaypalOder(PaypalOrder paypalOrder);

    PaypalOrder findUsrByTxnid(String txnid);

    void savePayPalOrders(List<PaypalOrder> list);

    List<PaypalOrder> findPaypalByUsrId(String usrId);

    List<PaypalOrder> findPaypalByUsrIdAndDate(String usrId, String dateFrom, String dateTo);

    List<PaypalOrder> findPaypalByUsrIdAndWhere(String usrId, Map<String, String> where);
}

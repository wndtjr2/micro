package com.wise.csv.svc;

import com.wise.csv.dao.PaypalOrderDao;
import com.wise.csv.model.PaypalOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.svc
 * FileName : PaypalOrderServiceImpl
 * Date : 16. 12. 6
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Service
public class PaypalOrderServiceImpl implements PaypalOrderService {

    @Autowired
    private PaypalOrderDao dao;

    @Override
    public void savePaypalOder(PaypalOrder paypalOrder) {
        dao.savePaypalOder(paypalOrder);
    }

    @Override
    public void updatePaypalOder(PaypalOrder paypalOrder) {
        PaypalOrder entity = dao.findUsrByTxnid(paypalOrder.getTransactionId());
        if (entity!=null){
            entity.setDate(paypalOrder.getDate());
            entity.setTime(paypalOrder.getTime());
            entity.setTimeZone(paypalOrder.getTimeZone());
            entity.setName(paypalOrder.getName());
            entity.setType(paypalOrder.getType());
            entity.setStatus(paypalOrder.getStatus());
            entity.setCurrency(paypalOrder.getCurrency());
            entity.setGross(paypalOrder.getGross());
            entity.setFee(paypalOrder.getFee());
            entity.setNet(paypalOrder.getNet());
            entity.setFromEmailAddress(paypalOrder.getFromEmailAddress());
            entity.setToEmailAddress(paypalOrder.getToEmailAddress());
            entity.setShippingAddress(paypalOrder.getShippingAddress());
            entity.setAddressStatus(paypalOrder.getAddressStatus());
            entity.setShippingAndHandlingAmount(paypalOrder.getShippingAndHandlingAmount());
            entity.setInsuranceAmount(paypalOrder.getInsuranceAmount());
            entity.setSalesTax(paypalOrder.getSalesTax());
            entity.setReferenceTxnId(paypalOrder.getReferenceTxnId());
            entity.setInvoiceNumber(paypalOrder.getInvoiceNumber());
            entity.setReceiptId(paypalOrder.getReceiptId());
            entity.setBalance(paypalOrder.getBalance());
            entity.setAddressLine1(paypalOrder.getAddressLine1());
            entity.setAddressLine2(paypalOrder.getAddressLine2());
            entity.setTown(paypalOrder.getTown());
            entity.setState(paypalOrder.getState());
            entity.setZip(paypalOrder.getZip());
            entity.setCountry(paypalOrder.getCountry());
            entity.setContactPhoneNumber(paypalOrder.getContactPhoneNumber());
            entity.setSubject(paypalOrder.getSubject());
            entity.setNote(paypalOrder.getNote());
        }
    }

    @Override
    public void deletePaypalOder(PaypalOrder paypalOrder) {

    }

    @Override
    public PaypalOrder findUsrByTxnid(String txnid) {
        return dao.findUsrByTxnid(txnid);
    }

    @Override
    @Transactional
    public void savePayPalOrders(List<PaypalOrder> list) {
        for (PaypalOrder paypalOrder : list){
            savePaypalOder(paypalOrder);
        }
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrId(String usrId){
        return dao.findPaypalByUsrId(usrId);
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrIdAndDate(String usrId, String dateFrom, String dateTo){
        return dao.findPaypalByUsrIdAndDate(usrId, dateFrom, dateTo);
    }

    @Override
    public List<PaypalOrder> findPaypalByUsrIdAndWhere(String usrId, Map<String, String> where) {
        return dao.findPaypalByUsrIdAndWhere(usrId, where);
    }
}
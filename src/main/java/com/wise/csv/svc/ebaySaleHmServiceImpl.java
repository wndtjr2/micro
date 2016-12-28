package com.wise.csv.svc;

import com.wise.csv.model.eBaySaleHm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.api.t.svc
 * FileName : EbayServiceImpl
 * Date : 16. 12. 5
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Service
public class ebaySaleHmServiceImpl implements ebaySaleHmService {

    @Autowired
    private com.wise.csv.dao.ebaySaleHmDao ebaySaleHmDao;

    @Override
    public eBaySaleHm findBysalesRecordNumber(String salesRecordNumber) {
        return ebaySaleHmDao.findBysalesRecordNumber(salesRecordNumber);
    }

    @Override
    public void createEbay(eBaySaleHm ebay) {
        ebaySaleHmDao.createEbay(ebay);
    }

    @Override
    public List<eBaySaleHm> listEbay(String usrid) {
        return ebaySaleHmDao.listEbay(usrid);
    }

    @Override
    public void updateEbay(eBaySaleHm ebay) {
        eBaySaleHm entity = ebaySaleHmDao.findBysalesRecordNumber(ebay.getSalesRecordNumber());
        if (entity!=null){
            entity.setUserId(ebay.getUserId());
            entity.setBuyerFullname(ebay.getBuyerFullname());
            entity.setBuyerPhoneNumber(ebay.getBuyerPhoneNumber());
            entity.setBuyerEmail(ebay.getBuyerEmail());
            entity.setBuyerAddress1(ebay.getBuyerAddress1());
            entity.setBuyerAddress2(ebay.getBuyerAddress2());
            entity.setBuyerCity(ebay.getBuyerCity());
            entity.setBuyerState(ebay.getBuyerState());
            entity.setBuyerZip(ebay.getBuyerZip());
            entity.setBuyerCountry(ebay.getBuyerCountry());
            entity.setOrderId(ebay.getOrderId());
            entity.setQuantity(ebay.getQuantity());
            entity.setSalePrice(ebay.getSalePrice());
            entity.setShippingAndHandling(ebay.getShippingAndHandling());
            entity.setSalesTax(ebay.getSalesTax());
            entity.setInsurance(ebay.getInsurance());
            entity.setTotalPrice(ebay.getTotalPrice());
            entity.setPaymentMethod(ebay.getPaymentMethod());
            entity.setPaypalTransactionId(ebay.getPaypalTransactionId());
            entity.setSaleDate(ebay.getSaleDate());
            entity.setCheckoutDate(ebay.getCheckoutDate());
            entity.setPaidOnDate(ebay.getPaidOnDate());
            entity.setShippingService(ebay.getShippingService());
        }
    }

    /*@Override
    public void deleteEbay(Ebay ebay) {
        eBaySaleHm entity = ebaySaleHmDao.findBysales_record_number(ebay.getSalesRecordNumber());
        if (entity!=null){
            entity.setDelflag("Y");
            entity.setDeldate(new Date());
        }
    }*/

    @Override
    public void createEbaySaleHm(List<eBaySaleHm> eBaySaleHms) {
        ebaySaleHmDao.createEbaySaleHm(eBaySaleHms);
    }

    @Override
    public List<eBaySaleHm> findByUserId(String usrid){
        return ebaySaleHmDao.findByUserId(usrid);
    }

    @Override
    public List<eBaySaleHm> findByUserIdWithDate(String usrid, String dtFrom, String dtTo){
        return ebaySaleHmDao.findByUserIdWithDate(usrid, dtFrom, dtTo);
    }

    @Override
    public List<eBaySaleHm> findByUserIdWithWhere(String usrid, Map<String, String> where) {
        return ebaySaleHmDao.findByUserIdWithWhere(usrid, where);
    }
}
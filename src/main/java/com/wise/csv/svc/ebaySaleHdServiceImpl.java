package com.wise.csv.svc;

import com.wise.csv.model.eBaySaleHd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.api.t.svc
 * FileName : EbayServiceImpl
 * Date : 16. 12. 5
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Service
public class ebaySaleHdServiceImpl implements ebaySaleHdService {

    @Autowired
    private com.wise.csv.dao.ebaySaleHdDao ebaySaleHdDao;

    @Override
    public eBaySaleHd findBySalesRecordNumber(String salesRecordNumber) {
        return ebaySaleHdDao.findBySalesRecordNumber(salesRecordNumber);
    }

    @Override
    public eBaySaleHd findBySalesTransactionId(String transactionId, String itemId, String salesRecordNumber) {
        return ebaySaleHdDao.findBySalesTransactionId(transactionId, itemId, salesRecordNumber);
    }

    @Override
    public void createEbay(eBaySaleHd ebay) {
        ebaySaleHdDao.createEbay(ebay);
    }

    @Override
    public List<eBaySaleHd> listEbay() {
        return ebaySaleHdDao.listEbay();
    }

    @Override
    public void updateEbay(eBaySaleHd ebay) {
        eBaySaleHd entity = ebaySaleHdDao.findBySalesRecordNumber(ebay.getSalesRecordNumber());
        if (entity!=null){
            entity.setItemId(ebay.getItemId());
            entity.setTransactionId(ebay.getTransactionId());
            entity.setItemTitle(ebay.getItemTitle());
            entity.setQuantity(ebay.getQuantity());
            entity.setSalePrice(ebay.getSalePrice());
            entity.setFeedbackLeft(ebay.getFeedbackLeft());
            entity.setFeedbackReceived(ebay.getFeedbackReceived());
            entity.setNotesToYourself(ebay.getNotesToYourself());
            entity.setCustomLabel(ebay.getCustomLabel());
            entity.setListedOn(ebay.getListedOn());
            entity.setPrivateNotes(ebay.getPrivateNotes());
            entity.setProductIdType(ebay.getProductIdType());
            entity.setProductIdValue(ebay.getProductIdValue());
            entity.setProductIdValue2(ebay.getProductIdValue2());
            entity.setVariationDetails(ebay.getVariationDetails());
            entity.setProductReferenceId(ebay.getProductReferenceId());
            entity.setTrackingNumber(ebay.getTrackingNumber());
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
    public void createEbayHmHd(List<eBaySaleHd> eBaySaleHds) {
        ebaySaleHdDao.createEbayHmHd(eBaySaleHds);
    }
}
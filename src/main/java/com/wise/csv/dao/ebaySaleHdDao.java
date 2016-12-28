package com.wise.csv.dao;

import com.wise.csv.model.eBaySaleHd;

import java.util.List;

/**
 * Created by wisecommerce on 16. 12. 5.
 */
public interface ebaySaleHdDao {
    eBaySaleHd findBySalesRecordNumber(String salesRecordNumber);
    eBaySaleHd findBySalesTransactionId(String transactionId, String itemId, String salesRecordNumber);
    void createEbay(eBaySaleHd ebay);
    List<eBaySaleHd> listEbay();

    void createEbayHmHd(List<eBaySaleHd> eBaySaleHds);
}

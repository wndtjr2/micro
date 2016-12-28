package com.wise.csv.svc;

import com.wise.csv.model.eBaySaleHd;

import java.util.List;

/**
 * Created by wisecommerce on 16. 12. 5.
 */
public interface ebaySaleHdService {
    eBaySaleHd findBySalesRecordNumber(String sales_record_number);
    eBaySaleHd findBySalesTransactionId(String transactionId, String iteId, String salesRecordNumber);
    void createEbay(eBaySaleHd ebay);
    List<eBaySaleHd> listEbay();
    void updateEbay(eBaySaleHd ebay);
    /*void deleteEbay(eBaySaleHm ebay);*/

    void createEbayHmHd(List<eBaySaleHd> eBaySaleHds);
}

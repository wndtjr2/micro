package com.wise.csv.dao;

import com.wise.csv.model.eBaySaleHm;

import java.util.List;
import java.util.Map;

/**
 * Created by wisecommerce on 16. 12. 5.
 */
public interface ebaySaleHmDao {

    eBaySaleHm findBysalesRecordNumber(String salesRecordNumber);

    eBaySaleHm findBySRNUsrid(String salesRecordNumber, String usrid);

    void createEbay(eBaySaleHm ebay);

    List<eBaySaleHm> listEbay(String usrid);

    void createEbaySaleHm(List<eBaySaleHm> eBaySaleHms);

    List<eBaySaleHm> findByUserId(String usrid);

    List<eBaySaleHm> findByUserIdWithDate(String usrid, String dtFrom, String dtTo);

    List<eBaySaleHm> findByUserIdWithWhere(String usrid, Map<String, String> where);
}

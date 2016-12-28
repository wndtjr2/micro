package com.wise.csv.svc;

import com.wise.csv.model.eBaySaleHm;

import java.util.List;
import java.util.Map;

/**
 * Created by wisecommerce on 16. 12. 5.
 */
public interface ebaySaleHmService {
    eBaySaleHm findBysalesRecordNumber(String salesRecordNumber);
    void createEbay(eBaySaleHm ebay);
    List<eBaySaleHm> listEbay(String usrid);
    void updateEbay(eBaySaleHm ebay);
    /*void deleteEbay(eBaySaleHm ebay);*/

    void createEbaySaleHm(List<eBaySaleHm> eBaySaleHms);

    List<eBaySaleHm> findByUserId(String usrid);

    List<eBaySaleHm> findByUserIdWithDate(String usrid, String dtFrom, String dtTo);

    List<eBaySaleHm> findByUserIdWithWhere(String usrid, Map<String, String> where);
}

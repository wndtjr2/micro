package com.wise.csv.cron;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : demo
 * Package : com.wise.test
 * FileName : EbayRequest
 * Date : 16. 12. 26
 * XmlElement : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */

@Data
public class EbayRequest {

    public EbayRequest(XmlElement xml) {
        this.xmlns = xml;
    }

    public void add(RequesterCredential token) {
        RequesterCredentials.add(token);
    }

    private XmlElement xmlns;

    private String ErrorLanguage = "en_US";

    private String WarningLevel = "High";

    private String OrderRole = "Seller";

    private String CreateTimeFrom;//2015-12-01T20:34:44.000Z

    private String CreateTimeTo;//2015-12-01T20:34:44.000Z

    private String OrderStatus = "Completed";

    private String DetailLevel = "ReturnAll";
//
//    @XStreamImplicit(itemFieldName="RequesterCredentials")
    private List RequesterCredentials = new ArrayList();


}
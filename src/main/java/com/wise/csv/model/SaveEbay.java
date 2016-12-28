package com.wise.csv.model;

/**
 * Project : order.wiseservice.io
 * Package : com.wise.csv.model
 * FileName : SaveEbay
 * Date : 16. 12. 28
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by benny on 16. 12. 28.
 */
@Data
@Document(collection = "ebay_csv")
public class SaveEbay {
    private String salesRecordNumber;

    private String userId;
    private String buyerFullname;
    private String buyerPhoneNumber;
    private String buyerEmail;
    private String buyerAddress1;
    private String buyerAddress2;
    private String buyerCity;
    private String buyerState;
    private String buyerZip;
    private String buyerCountry;
    private String orderId;

    private String shippingAndHandling;
    private String salesTax;
    private String insurance;
    private String totalPrice;
    private String paymentMethod;
    private String paypalTransactionId;

    private String checkoutDate;

    private Date checkout_date_db;

    private String paidOnDate;

    private Date paid_on_date_db;

    private String shippedOnDate;

    private Date shipped_on_date_db;

    private String shippingService;

    private String feedbackReceived;
    private String notesToYourself;

    private String soldOn;
    private String privateNotes;
    private String productIdType;
    private String productIdValue;
    private String productIdValue2;
    private String variationDetails;
    private String productReferenceId;
    private String trackingNumber;

    private String globalShippingReferenceId;
    private String shipToAddress1;
    private String shipToAddress2;
    private String shipToCity;
    private String shipToZip;
    private String shipToCountry;

    private List<EbayItems> ebayItemss;

    private String delflag;

    private Date deldate;

    private String mbrNo;

    private String type;

    private String mbrStoNo;
}
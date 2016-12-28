package com.wise.csv.model;

/**
 * Project : order.wiseservice.io
 * Package : com.wise.csv.model
 * FileName : EbayItems
 * Date : 16. 12. 28
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
import lombok.Data;

import java.util.Date;

/**
 * Created by benny on 16. 12. 28.
 */
@Data
public class EbayItems {
    private String itemId;
    private String transactionId;
    private String itemTitle;
    private String quantity;
    private String salePrice;
    private String shippingAndHandling;
    private String salesTax;
    private String insurance;
    private String totalPrice;
    private String paymentMethod;
    private String paypalTransactionId;

    private String saleDate;

    private Date sale_date_db;

    private String checkoutDate;

    private Date checkout_date_db;

    private String paidOnDate;

    private Date paid_on_date_db;

    private String shippedOnDate;

    private Date shipped_on_date_db;

    private String shippingService;
    private String feedbackLeft;
    private String feedbackReceived;
    private String notesToYourself;
    private String customLabel;
    private String listedOn;
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
}
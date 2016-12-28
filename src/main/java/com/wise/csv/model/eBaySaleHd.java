package com.wise.csv.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.model
 * FileName : eBaySaleHd
 * Date : 16. 12. 7
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */

@Entity(name = "tb_ebay_sale_hd")
public class eBaySaleHd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(name = "sales_record_number")
    private String salesRecordNumber;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "sale_price")
    private String salePrice;

    @Column(name = "sale_date")
    private String saleDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date_db")
    private Date saleDateDb;

    @Column(name = "feedback_left")
    private String feedbackLeft;

    @Column(name = "feedback_received")
    private String feedbackReceived;

    @Column(name = "notes_to_yourself")
    private String notesToYourself;

    @Column(name = "custom_label")
    private String customLabel;

    @Column(name = "listed_on")
    private String listedOn;

    @Column(name = "private_notes")
    private String privateNotes;

    @Column(name = "product_id_type")
    private String productIdType;

    @Column(name = "product_id_value")
    private String productIdValue;

    @Column(name = "product_id_value2")
    private String productIdValue2;

    @Column(name = "variation_details")
    private String variationDetails;

    @Column(name = "product_reference_id")
    private String productReferenceId;

    @Column(name = "tracking_number")
    private String trackingNumber;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSalesRecordNumber() {
        return salesRecordNumber;
    }

    public void setSalesRecordNumber(String salesRecordNumber) {
        this.salesRecordNumber = salesRecordNumber;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Date getSaleDateDb() {
        return saleDateDb;
    }

    public void setSaleDateDb(Date saleDateDb) {
        this.saleDateDb = saleDateDb;
    }

    public String getFeedbackLeft() {
        return feedbackLeft;
    }

    public void setFeedbackLeft(String feedbackLeft) {
        this.feedbackLeft = feedbackLeft;
    }

    public String getFeedbackReceived() {
        return feedbackReceived;
    }

    public void setFeedbackReceived(String feedbackReceived) {
        this.feedbackReceived = feedbackReceived;
    }

    public String getNotesToYourself() {
        return notesToYourself;
    }

    public void setNotesToYourself(String notesToYourself) {
        this.notesToYourself = notesToYourself;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }

    public String getListedOn() {
        return listedOn;
    }

    public void setListedOn(String listedOn) {
        this.listedOn = listedOn;
    }

    public String getPrivateNotes() {
        return privateNotes;
    }

    public void setPrivateNotes(String privateNotes) {
        this.privateNotes = privateNotes;
    }

    public String getProductIdType() {
        return productIdType;
    }

    public void setProductIdType(String productIdType) {
        this.productIdType = productIdType;
    }

    public String getProductIdValue() {
        return productIdValue;
    }

    public void setProductIdValue(String productIdValue) {
        this.productIdValue = productIdValue;
    }

    public String getProductIdValue2() {
        return productIdValue2;
    }

    public void setProductIdValue2(String productIdValue2) {
        this.productIdValue2 = productIdValue2;
    }

    public String getVariationDetails() {
        return variationDetails;
    }

    public void setVariationDetails(String variationDetails) {
        this.variationDetails = variationDetails;
    }

    public String getProductReferenceId() {
        return productReferenceId;
    }

    public void setProductReferenceId(String productReferenceId) {
        this.productReferenceId = productReferenceId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        return "eBaySaleHd{" +
                "no=" + no +
                ", salesRecordNumber='" + salesRecordNumber + '\'' +
                ", itemId='" + itemId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                ", quantity='" + quantity + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", saleDateDb=" + saleDateDb +
                ", feedbackLeft='" + feedbackLeft + '\'' +
                ", feedbackReceived='" + feedbackReceived + '\'' +
                ", notesToYourself='" + notesToYourself + '\'' +
                ", customLabel='" + customLabel + '\'' +
                ", listedOn='" + listedOn + '\'' +
                ", privateNotes='" + privateNotes + '\'' +
                ", productIdType='" + productIdType + '\'' +
                ", productIdValue='" + productIdValue + '\'' +
                ", productIdValue2='" + productIdValue2 + '\'' +
                ", variationDetails='" + variationDetails + '\'' +
                ", productReferenceId='" + productReferenceId + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                '}';
    }
}
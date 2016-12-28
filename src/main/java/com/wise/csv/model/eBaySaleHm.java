package com.wise.csv.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.model
 * FileName : eBaySaleHm
 * Date : 16. 12. 7
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Entity(name = "tb_ebay_sale_hm")
public class eBaySaleHm {
    @Id
    @Column(name = "sales_record_number")
    private String salesRecordNumber;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "buyer_fullname")
    private String buyerFullname;
    @Column(name = "buyer_phone_number")
    private String buyerPhoneNumber;
    @Column(name = "buyer_email")
    private String buyerEmail;
    @Column(name = "buyer_address1")
    private String buyerAddress1;
    @Column(name = "buyer_address2")
    private String buyerAddress2;
    @Column(name = "buyer_city")
    private String buyerCity;
    @Column(name = "buyer_state")
    private String buyerState;
    @Column(name = "buyer_zip")
    private String buyerZip;
    @Column(name = "buyer_country")
    private String buyerCountry;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "sale_price")
    private String salePrice;
    @Column(name = "shipping_and_handling")
    private String shippingAndHandling;
    @Column(name = "sales_tax")
    private String salesTax;
    @Column(name = "insurance")
    private String insurance;
    @Column(name = "total_price")
    private String totalPrice;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "paypal_transaction_id")
    private String paypalTransactionId;
    @Column(name = "sale_date")
    private String saleDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date_db")
    private Date saleDateDb;
    @Column(name = "checkout_date")
    private String checkoutDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "checkout_date_db")
    private Date checkoutDateDb;
    @Column(name = "paid_on_date")
    private String paidOnDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "paid_on_date_db")
    private Date paidOnDateDb;
    @Column(name = "shipping_service")
    private String shippingService;
    @Column(name = "sold_on")
    private String soldOn;

    @Column(name = "cbt_user_id")
    private String cbtUserId;

    public String getSalesRecordNumber() {
        return salesRecordNumber;
    }

    public void setSalesRecordNumber(String salesRecordNumber) {
        this.salesRecordNumber = salesRecordNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyerFullname() {
        return buyerFullname;
    }

    public void setBuyerFullname(String buyerFullname) {
        this.buyerFullname = buyerFullname;
    }

    public String getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public void setBuyerPhoneNumber(String buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerAddress1() {
        return buyerAddress1;
    }

    public void setBuyerAddress1(String buyerAddress1) {
        this.buyerAddress1 = buyerAddress1;
    }

    public String getBuyerAddress2() {
        return buyerAddress2;
    }

    public void setBuyerAddress2(String buyerAddress2) {
        this.buyerAddress2 = buyerAddress2;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    public String getBuyerState() {
        return buyerState;
    }

    public void setBuyerState(String buyerState) {
        this.buyerState = buyerState;
    }

    public String getBuyerZip() {
        return buyerZip;
    }

    public void setBuyerZip(String buyerZip) {
        this.buyerZip = buyerZip;
    }

    public String getBuyerCountry() {
        return buyerCountry;
    }

    public void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getShippingAndHandling() {
        return shippingAndHandling;
    }

    public void setShippingAndHandling(String shippingAndHandling) {
        this.shippingAndHandling = shippingAndHandling;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaypalTransactionId() {
        return paypalTransactionId;
    }

    public void setPaypalTransactionId(String paypalTransactionId) {
        this.paypalTransactionId = paypalTransactionId;
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

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getCheckoutDateDb() {
        return checkoutDateDb;
    }

    public void setCheckoutDateDb(Date checkoutDateDb) {
        this.checkoutDateDb = checkoutDateDb;
    }

    public String getPaidOnDate() {
        return paidOnDate;
    }

    public void setPaidOnDate(String paidOnDate) {
        this.paidOnDate = paidOnDate;
    }

    public Date getPaidOnDateDb() {
        return paidOnDateDb;
    }

    public void setPaidOnDateDb(Date paidOnDateDb) {
        this.paidOnDateDb = paidOnDateDb;
    }

    public String getShippingService() {
        return shippingService;
    }

    public void setShippingService(String shippingService) {
        this.shippingService = shippingService;
    }

    public String getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(String soldOn) {
        this.soldOn = soldOn;
    }

    public String getCbtUserId() {
        return cbtUserId;
    }

    public void setCbtUserId(String cbtUserId) {
        this.cbtUserId = cbtUserId;
    }

    @Override
    public String toString() {
        return "eBaySaleHm{" +
                "salesRecordNumber='" + salesRecordNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", buyerFullname='" + buyerFullname + '\'' +
                ", buyerPhoneNumber='" + buyerPhoneNumber + '\'' +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", buyerAddress1='" + buyerAddress1 + '\'' +
                ", buyerAddress2='" + buyerAddress2 + '\'' +
                ", buyerCity='" + buyerCity + '\'' +
                ", buyerState='" + buyerState + '\'' +
                ", buyerZip='" + buyerZip + '\'' +
                ", buyerCountry='" + buyerCountry + '\'' +
                ", orderId='" + orderId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", shippingAndHandling='" + shippingAndHandling + '\'' +
                ", salesTax='" + salesTax + '\'' +
                ", insurance='" + insurance + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paypalTransactionId='" + paypalTransactionId + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", saleDateDb=" + saleDateDb +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", checkoutDateDb=" + checkoutDateDb +
                ", paidOnDate='" + paidOnDate + '\'' +
                ", paidOnDateDb=" + paidOnDateDb +
                ", shippingService='" + shippingService + '\'' +
                ", soldOn='" + soldOn + '\'' +
                ", cbtUserId='" + cbtUserId + '\'' +
                '}';
    }
}
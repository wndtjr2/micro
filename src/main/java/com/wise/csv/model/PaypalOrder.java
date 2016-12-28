package com.wise.csv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Project : benny-usr
 * Package : com.wise.cbt.pay.usr.model
 * FileName : PaypalOrderDao
 * Date : 16. 12. 6
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Entity(name = "tb_paypal_orders_csv")
public class PaypalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @NotNull
    private String date;

    @NotNull
    private String time;

    @NotNull
    private String timeZone;

    public String getCbt_user_id() {
        return cbt_user_id;
    }

    public void setCbt_user_id(String cbt_user_id) {
        this.cbt_user_id = cbt_user_id;
    }

    @NotNull
    private String cbt_user_id;

    private String name;

    private String type;

    private String status;

    private String currency;

    private String gross;

    private String fee;

    private String net;

    private String fromEmailAddress;

    private String toEmailAddress;

    private String transactionId;

    private String shippingAddress;

    private String addressStatus;

    private String shippingAndHandlingAmount;

    private String insuranceAmount;

    private String salesTax;

    private String referenceTxnId;

    private String invoiceNumber;

    private String receiptId;

    private String balance;

    private String addressLine1;

    private String addressLine2;

    private String town;

    private String state;

    private String zip;

    private String country;

    private String contactPhoneNumber;

    private String subject;

    private String note;

    public PaypalOrder() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getToEmailAddress() {
        return toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus;
    }

    public String getShippingAndHandlingAmount() {
        return shippingAndHandlingAmount;
    }

    public void setShippingAndHandlingAmount(String shippingAndHandlingAmount) {
        this.shippingAndHandlingAmount = shippingAndHandlingAmount;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getReferenceTxnId() {
        return referenceTxnId;
    }

    public void setReferenceTxnId(String referenceTxnId) {
        this.referenceTxnId = referenceTxnId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PaypalOrder{" +
                "date='" + date + '\'' +
                ", cbt_user_id=" + cbt_user_id + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", currency='" + currency + '\'' +
                ", gross='" + gross + '\'' +
                ", fee='" + fee + '\'' +
                ", net='" + net + '\'' +
                ", fromEmailAddress='" + fromEmailAddress + '\'' +
                ", toEmailAddress='" + toEmailAddress + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", addressStatus='" + addressStatus + '\'' +
                ", shippingAndHandlingAmount='" + shippingAndHandlingAmount + '\'' +
                ", insuranceAmount='" + insuranceAmount + '\'' +
                ", salesTax='" + salesTax + '\'' +
                ", referenceTxnId='" + referenceTxnId + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", receiptId='" + receiptId + '\'' +
                ", balance='" + balance + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", town='" + town + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
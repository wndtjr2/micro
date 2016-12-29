package com.wise.csv.cntlr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import com.wise.comm.bean.RespObj;
import com.wise.comm.utill.DateUtil;
import com.wise.comm.utill.SeedUtil;
import com.wise.csv.model.Ebay;
import com.wise.csv.model.EbayItems;
import com.wise.csv.model.SaveEbay;
import com.wise.mbr.model.MemberInfo;
import com.wise.mbr.model.MemberTermsInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;

/**
 * Project : demo
 * Package : com.wise.ebay.cntlr
 * FileName : EbayCntlr
 * Date : 16. 12. 27
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@RestController
public class EbayCntlr {

    public Logger log = LoggerFactory.getLogger(EbayCntlr.class);

    public RespObj resobj;

    public String type = "csv";

    public MongoOperations mongoOperations = new MongoTemplate(new Mongo(), "db_order");

    /*@RequestMapping(value = "/cbt/mbr/add", method = RequestMethod.POST)
    @ResponseBody
    public Map addMember(@RequestBody Map<String, Object> reqmap) {
        resobj = new RespObj();
        logger.debug("requestBody reqmap = "+reqmap);
        ObjectMapper om = new ObjectMapper();
        try {
            if (!reqmap.isEmpty()){
               *//*MemberInfo member = om.readValue((String)reqmap.get("member"), MemberInfo.class);*//*
               *//*MemberInfo member = (MemberInfo) reqmap.get("member");*//*

                MemberInfo member = om.convertValue(reqmap.get("member"), MemberInfo.class);

                String pwd = member.getPwd();
                String encPwd = SeedUtil.getSeedEncrypt(pwd);
                member.setPwd(encPwd);
                member.setRegistrantDtm(DateUtil.getTimestamp());
                member.setMbrDelYn('N');
                long mbrNo = mbrSvc.mbrCreate(member);
                logger.debug("member.toString() :: "+member.toString());
                logger.debug("mbrNo :::::::::::::: "+mbrNo);

               *//*ArrayList<String> mbrList = (ArrayList<String>) reqmap.get("terms");

               for (String getTerm : mbrList) {
                   MemberTermsInfo term = om.readValue( getTerm , MemberTermsInfo.class);
                   logger.debug("term ::::::::::::::: " + term);
                   term.setMbr_no(mbrNo);
                   term.setTerm_agree_dtm(DateUtil.getTimestamp());
                   mbrSvc.mbrTermsCreate(term);
               }*//*

                ObjectMapper mapper = new ObjectMapper();
                List<MemberTermsInfo> memberTermsInfos = mapper.convertValue(reqmap.get("terms"),
                        new TypeReference<List<MemberTermsInfo>>() { });
                for (MemberTermsInfo memberTermsInfo : memberTermsInfos){
                    memberTermsInfo.setMbr_no(mbrNo);
                    memberTermsInfo.setTerm_agree_dtm(DateUtil.getTimestamp());
                    mbrSvc.mbrTermsCreate(memberTermsInfo);
                }

                resobj.Success();

            }else {
                resobj.Error("error","에러메세지");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resobj.getRespMap();
    }*/

    @RequestMapping(value = "/order/ebay/excel")
    public Map<String, Object> saveEbayCSV(@RequestBody Map<String, Object> postObject){

        log.info("request Obj ::::"+postObject);
        resobj = new RespObj();
        ObjectMapper om = new ObjectMapper();
        String mbr_no = om.convertValue(postObject.get("mbrNo"), String.class);
        String mbr_sto_no = om.convertValue(postObject.get("mbrStorNo"), String.class);
        List<Ebay> ebays = om.convertValue(postObject.get("ebays"),
                new TypeReference<List<Ebay>>() { });
        log.info("mbr_no ::::"+mbr_no+" :::: mbr_sto_no :::: "+mbr_sto_no+" :::: ebays.size :::: "+ebays.size());

        Map<String, Object> rtn = this.createEbay(ebays, mbr_no, mbr_sto_no);
        if (rtn!=null){
            resobj.Success(rtn);
            log.info("Success");
        }else {
            resobj.Error();
            log.info("Error");
        }

        log.info("rtn :::: "+rtn);
        return resobj.getRespMap();
    }

    public Map<String, Object> createEbay(List<Ebay> ebays, String mbrNo, String mbrStoNo) {
        //성공과 실패를 저장할 Object 생성
        Map<String, Object> map = new HashMap<String, Object>();

        //실패한 정보를 저장할 Object 생성
        List<Object> result = new ArrayList<Object>();
        //mongoDB에 저장할 Object 생성
        List<SaveEbay> saveEbays = new ArrayList<SaveEbay>();
        for (int i = 0;i<ebays.size();i++){
            if (i>0){
                //현재의 salesRecordNumber를 구하기 위한 Ebay
                Ebay nowEbay = ebays.get(i);
                String nowSalesRecordNumber = nowEbay.getSalesRecordNumber();

                //바로 직전의 salesRecordNumber를 구하기 위한 Ebay
                Ebay preEbay = ebays.get(i-1);
                String preSalesRecordNumber = preEbay.getSalesRecordNumber();


                SaveEbay saveEbay = new SaveEbay();
                List<EbayItems> ebayItems = new ArrayList<EbayItems>();

                //nowSalesRecordNumber 와 preSalesRecordNumber가 다르면 단일 건으로 처리
                try{
                    if (!nowSalesRecordNumber.equals(preSalesRecordNumber)){
                        //값 setting
                        saveEbay.setSalesRecordNumber(nowEbay.getSalesRecordNumber());
                        saveEbay.setUserId(nowEbay.getUserId());
                        saveEbay.setBuyerFullname(nowEbay.getBuyerFullname());
                        saveEbay.setBuyerPhoneNumber(nowEbay.getBuyerPhoneNumber());
                        saveEbay.setBuyerEmail(nowEbay.getBuyerEmail());
                        saveEbay.setBuyerAddress1(nowEbay.getBuyerAddress1());
                        saveEbay.setBuyerAddress2(nowEbay.getBuyerAddress2());
                        saveEbay.setBuyerCity(nowEbay.getBuyerCity());
                        saveEbay.setBuyerState(nowEbay.getBuyerState());
                        saveEbay.setBuyerZip(nowEbay.getBuyerZip());
                        saveEbay.setBuyerCountry(nowEbay.getBuyerCountry());
                        saveEbay.setOrderId(nowEbay.getOrderId());
                        saveEbay.setShippingAndHandling(nowEbay.getShippingAndHandling());
                        saveEbay.setSalesTax(nowEbay.getSalesTax());
                        saveEbay.setInsurance(nowEbay.getInsurance());
                        saveEbay.setTotalPrice(nowEbay.getTotalPrice());
                        saveEbay.setPaymentMethod(nowEbay.getPaymentMethod());

                        //Date type 셋팅
                        saveEbay.setCheckoutDate(nowEbay.getCheckoutDate());
                        Date checkDate = dateformatter(nowEbay.getCheckoutDate());
                        saveEbay.setCheckout_date_db(checkDate);

                        saveEbay.setPaidOnDate(nowEbay.getPaidOnDate());
                        Date paidOnDate = dateformatter(nowEbay.getPaidOnDate());
                        saveEbay.setPaid_on_date_db(paidOnDate);

                        saveEbay.setShippedOnDate(nowEbay.getShippedOnDate());
                        Date shippedOnDate = dateformatter(nowEbay.getShippedOnDate());
                        saveEbay.setShipped_on_date_db(shippedOnDate);

                        saveEbay.setShippingService(nowEbay.getShippingService());
                        saveEbay.setNotesToYourself(nowEbay.getNotesToYourself());
                        saveEbay.setSoldOn(nowEbay.getSoldOn());
                        saveEbay.setPrivateNotes(nowEbay.getPrivateNotes());
                        saveEbay.setProductIdType(nowEbay.getProductIdType());
                        saveEbay.setProductIdValue(nowEbay.getProductIdValue());
                        saveEbay.setProductIdValue2(nowEbay.getProductIdValue2());
                        saveEbay.setVariationDetails(nowEbay.getVariationDetails());
                        saveEbay.setProductReferenceId(nowEbay.getProductReferenceId());
                        saveEbay.setTrackingNumber(nowEbay.getTrackingNumber());
                        saveEbay.setGlobalShippingReferenceId(nowEbay.getGlobalShippingReferenceId());
                        saveEbay.setShipToAddress1(nowEbay.getShipToAddress1());
                        saveEbay.setShipToAddress2(nowEbay.getShipToAddress2());
                        saveEbay.setShipToCity(nowEbay.getShipToCity());
                        saveEbay.setShipToZip(nowEbay.getShipToZip());
                        saveEbay.setShipToCountry(nowEbay.getShipToCountry());

                        //SaveEbay 속 EbayItems셋팅
                        if (!nowEbay.getItemId().isEmpty() || nowEbay.getItemId()!=null){
                            EbayItems ebayItem = new EbayItems();

                            ebayItem.setItemId(nowEbay.getItemId());
                            ebayItem.setTransactionId(nowEbay.getTransactionId());
                            ebayItem.setItemTitle(nowEbay.getItemTitle());
                            ebayItem.setQuantity(nowEbay.getQuantity());
                            ebayItem.setSalePrice(nowEbay.getSalePrice());
                            ebayItem.setShippingAndHandling(nowEbay.getShippingAndHandling());
                            ebayItem.setSalesTax(nowEbay.getSalesTax());
                            ebayItem.setInsurance(nowEbay.getInsurance());
                            ebayItem.setTotalPrice(nowEbay.getTotalPrice());
                            ebayItem.setPaymentMethod(nowEbay.getPaymentMethod());
                            ebayItem.setPaypalTransactionId(nowEbay.getPaypalTransactionId());

                            //Date type 셋팅
                            ebayItem.setCheckoutDate(nowEbay.getCheckoutDate());
                            ebayItem.setCheckout_date_db(checkDate);

                            ebayItem.setPaidOnDate(nowEbay.getPaidOnDate());
                            ebayItem.setPaid_on_date_db(paidOnDate);

                            ebayItem.setShippedOnDate(nowEbay.getShippedOnDate());
                            ebayItem.setShipped_on_date_db(shippedOnDate);

                            ebayItem.setShippingService(nowEbay.getShippingService());
                            ebayItem.setFeedbackLeft(nowEbay.getFeedbackLeft());
                            ebayItem.setFeedbackReceived(nowEbay.getFeedbackReceived());
                            ebayItem.setNotesToYourself(nowEbay.getNotesToYourself());
                            ebayItem.setCustomLabel(nowEbay.getCustomLabel());
                            ebayItem.setListedOn(nowEbay.getListedOn());
                            ebayItem.setSoldOn(nowEbay.getSoldOn());
                            ebayItem.setPrivateNotes(nowEbay.getPrivateNotes());
                            ebayItem.setProductIdType(nowEbay.getProductIdType());
                            ebayItem.setProductIdValue(nowEbay.getProductIdValue());
                            ebayItem.setProductIdValue2(nowEbay.getProductIdValue2());
                            ebayItem.setVariationDetails(nowEbay.getVariationDetails());
                            ebayItem.setProductReferenceId(nowEbay.getProductReferenceId());
                            ebayItem.setTrackingNumber(nowEbay.getTrackingNumber());
                            ebayItem.setGlobalShippingReferenceId(nowEbay.getGlobalShippingReferenceId());
                            ebayItem.setShipToAddress1(nowEbay.getShipToAddress1());
                            ebayItem.setShipToAddress2(nowEbay.getShipToAddress2());
                            ebayItem.setShipToCity(nowEbay.getShipToCity());
                            ebayItem.setShipToZip(nowEbay.getShipToZip());
                            ebayItem.setShipToCountry(nowEbay.getShipToCountry());

                            ebayItems.add(ebayItem);
                        }

                    }else if (nowSalesRecordNumber.equals(preSalesRecordNumber) && !nowEbay.getItemId().isEmpty()){
                        EbayItems ebayItem = new EbayItems();

                        ebayItem.setItemId(nowEbay.getItemId());
                        ebayItem.setTransactionId(nowEbay.getTransactionId());
                        ebayItem.setItemTitle(nowEbay.getItemTitle());
                        ebayItem.setQuantity(nowEbay.getQuantity());
                        ebayItem.setSalePrice(nowEbay.getSalePrice());
                        ebayItem.setShippingAndHandling(nowEbay.getShippingAndHandling());
                        ebayItem.setSalesTax(nowEbay.getSalesTax());
                        ebayItem.setInsurance(nowEbay.getInsurance());
                        ebayItem.setTotalPrice(nowEbay.getTotalPrice());
                        ebayItem.setPaymentMethod(nowEbay.getPaymentMethod());
                        ebayItem.setPaypalTransactionId(nowEbay.getPaypalTransactionId());

                        //Date type 셋팅
                        saveEbay.setCheckoutDate(nowEbay.getCheckoutDate());
                        Date checkDate = dateformatter(nowEbay.getCheckoutDate());
                        saveEbay.setCheckout_date_db(checkDate);

                        saveEbay.setPaidOnDate(nowEbay.getPaidOnDate());
                        Date paidOnDate = dateformatter(nowEbay.getPaidOnDate());
                        saveEbay.setPaid_on_date_db(paidOnDate);

                        saveEbay.setShippedOnDate(nowEbay.getShippedOnDate());
                        Date shippedOnDate = dateformatter(nowEbay.getShippedOnDate());
                        saveEbay.setShipped_on_date_db(shippedOnDate);

                        ebayItem.setShippingService(nowEbay.getShippingService());
                        ebayItem.setFeedbackLeft(nowEbay.getFeedbackLeft());
                        ebayItem.setFeedbackReceived(nowEbay.getFeedbackReceived());
                        ebayItem.setNotesToYourself(nowEbay.getNotesToYourself());
                        ebayItem.setCustomLabel(nowEbay.getCustomLabel());
                        ebayItem.setListedOn(nowEbay.getListedOn());
                        ebayItem.setSoldOn(nowEbay.getSoldOn());
                        ebayItem.setPrivateNotes(nowEbay.getPrivateNotes());
                        ebayItem.setProductIdType(nowEbay.getProductIdType());
                        ebayItem.setProductIdValue(nowEbay.getProductIdValue());
                        ebayItem.setProductIdValue2(nowEbay.getProductIdValue2());
                        ebayItem.setVariationDetails(nowEbay.getVariationDetails());
                        ebayItem.setProductReferenceId(nowEbay.getProductReferenceId());
                        ebayItem.setTrackingNumber(nowEbay.getTrackingNumber());
                        ebayItem.setGlobalShippingReferenceId(nowEbay.getGlobalShippingReferenceId());
                        ebayItem.setShipToAddress1(nowEbay.getShipToAddress1());
                        ebayItem.setShipToAddress2(nowEbay.getShipToAddress2());
                        ebayItem.setShipToCity(nowEbay.getShipToCity());
                        ebayItem.setShipToZip(nowEbay.getShipToZip());
                        ebayItem.setShipToCountry(nowEbay.getShipToCountry());

                        ebayItems.add(ebayItem);
                    }

                    //SaveEbay 속 EbayItems는
                    saveEbay.setEbayItemss(ebayItems);
                    saveEbay.setMbrNo(mbrNo);
                    saveEbay.setMbrStoNo(mbrStoNo);
                    saveEbay.setType(this.type);
                    saveEbays.add(saveEbay);

                    //저장 메서드
                    mongoOperations.save(saveEbay, "ebay_csv");

                }catch (Exception e){
                    result.add(nowEbay);
                }
            }

        }
        map.put("success", saveEbays);
        map.put("fail", result);
        return map;
    }


    @RequestMapping(value = "/cbt/mbr/add", method = RequestMethod.POST)
    @ResponseBody
    public Map addMember(@RequestBody Map<String, Object> reqmap) {
        resobj = new RespObj();
        log.debug("requestBody reqmap = "+reqmap);
        ObjectMapper om = new ObjectMapper();
        try {
            if (!reqmap.isEmpty()){
               /*MemberInfo member = om.readValue((String)reqmap.get("member"), MemberInfo.class);*/
               /*MemberInfo member = (MemberInfo) reqmap.get("member");*/

                MemberInfo member = om.convertValue(reqmap.get("member"), MemberInfo.class);

                String pwd = member.getPwd();
                String encPwd = SeedUtil.getSeedEncrypt(pwd);
                member.setPwd(encPwd);
                member.setRegistrantDtm(DateUtil.getTimestamp());
//                member.setMbrDelYn('N');
//                long mbrNo = mbrSvc.mbrCreate(member);
                log.debug("member.toString() :: "+member.toString());
//                log.debug("mbrNo :::::::::::::: "+mbrNo);

               /*ArrayList<String> mbrList = (ArrayList<String>) reqmap.get("terms");

               for (String getTerm : mbrList) {
                   MemberTermsInfo term = om.readValue( getTerm , MemberTermsInfo.class);
                   logger.debug("term ::::::::::::::: " + term);
                   term.setMbr_no(mbrNo);
                   term.setTerm_agree_dtm(DateUtil.getTimestamp());
                   mbrSvc.mbrTermsCreate(term);
               }*/

                ObjectMapper mapper = new ObjectMapper();
                List<MemberTermsInfo> memberTermsInfos = mapper.convertValue(reqmap.get("terms"),
                        new TypeReference<List<MemberTermsInfo>>() { });
                for (MemberTermsInfo memberTermsInfo : memberTermsInfos){
//                    memberTermsInfo.setMbr_no(mbrNo);
                    memberTermsInfo.setTerm_agree_dtm(DateUtil.getTimestamp());
//                    mbrSvc.mbrTermsCreate(memberTermsInfo);
                }

                resobj.Success();

            }else {
                resobj.Error("error","에러메세지");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resobj.getRespMap();
    }

    public Date dateformatter(String mmmddyy){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yy", Locale.US);
        SimpleDateFormat nsdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date nd = new Date();

        try {
            Date date = sdf.parse(mmmddyy);
            System.out.println("String to Date1 = "+date);
            String ndate = nsdf.format(date);
            System.out.println("String to Date2 = "+ndate);
            nd = nsdf.parse(ndate);
            System.out.println("String to Date3 = "+nd);
        }catch (Exception e){
            e.printStackTrace();
        }

        return nd;
    }

}
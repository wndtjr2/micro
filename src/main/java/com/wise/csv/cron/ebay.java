package com.wise.csv.cron;

import com.mongodb.Mongo;
import com.thoughtworks.xstream.XStream;
import com.wise.mbr.svc.MbrSvc;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * Project : demo
 * Package : com.wise.test
 * FileName : test
 * Date : 16. 12. 23
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@PropertySource(value="classpath:application.properties")
@Service
public class ebay {

    private Logger log = LoggerFactory.getLogger(ebay.class);

    public MongoOperations mongoOperations = new MongoTemplate(new Mongo(), "test");

    @Autowired
    public MbrSvc mbrSvc;

    private static Environment environment;

    @Scheduled(cron="*/5 * * * * *")
    public void apiRequest() throws Exception{

        System.out.println("\nTesting 2 - Send Http POST request");
        this.sendPost();

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String mbrNo = "1019";
        String token = "AgAAAA**AQAAAA**aAAAAA**madgWA**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GiCZSGogmdj6x9nY+seQ**7gUEAA**AAMAAA**KeRo8h5GEHLuGXnBmIGJDxMr3vH3tyftNTAFPdleYmSPWJhtFyVSQ2vvX8uUGXtkR40QwXuIZTAc9BMrN4mYR4kkVnKTrlqSqRFvN228s9lteZNAhDtDTzBCbwVhoDLnHUBQ7VJEiiH70j57jY/frimM7tm+tvA/T5tOrq5wVKmUlID7i4+kT2Evq9+ct6b9og0mIdptEwvQFxX9mYZPgjffUrJY8vueHUyvpHYs6IrHwWsLK7Lo0PEhBVWXeSbBTW1Bpej1eeinow3vi1E0zbBD0i/G3dGK0SmGvnrfOXLO6lPqvuTmbaYC0ytuI8wRkymDZJHmQCkWv/fnByhdFh+APZA67DcMaANwDVMadb5fcR3DfQrBynH8wlkeiVvS1hTVrUehXDUMXXmbmVzz6Gl/ajyboRK6KeV4cw4OJ/L2O+7RtmdT7Cw+U1JxTf4fHs7IwBw03/6lyzGN2QM6b9dXX3QDMwivWpLvbtEvoc0uV/jrakRpgk8lfnEG0jx6dX/MCBmOmMoXGHGycDKCU0QXdr3aQ4X+Zzw9kXPBNCrcRNolcnohgogkcg3+tKuLPfmzOi+1DCy3F6OP8+oy1d3QcqfELDDCdBLmF4V2QjbZkHvMk/i5ZxLguIWeCghgJjhvycVzKGdxHaPZ4FdV85M6PO9TJHt78C5OBreIVKhE/s0HjuWe+2SuPNPoq5p8I0ByEnp9psrD9QwkeKgNRw0/5xirsvlHMS9Ev7Sr+gZi0BKdi5d0NxyjM3xW4xK3";
        String AppId = "ericlee-test-SBX-245f64428-f8523264";
        String DevId = "94fafbb1-985b-465b-84a0-5ec26bc5e9aa";
        String CertId = "SBX-45f64428cfe8-81a7-4bb0-8eb7-c13a";



        String sandBoxUrl = "https://api.sandbox.ebay.com/ws/api.dll";
        //TODO Change Url to Real => String realUrl = "https://api.ebay.com/ws/api.dll";
        URL obj = new URL(sandBoxUrl);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/xml");
        con.setRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL", "967");
        con.setRequestProperty("X-EBAY-API-CALL-NAME", "GetOrders");
        con.setRequestProperty("X-EBAY-API-SITEID", "0");
        con.setRequestProperty("X-EBAY-API-APP-NAME", AppId);
        con.setRequestProperty("X-EBAY-API-DEV-NAME", DevId);
        con.setRequestProperty("X-EBAY-API-CERT-NAME", CertId);

        //Create XML to send data as POST
        EbayRequest ebay = new EbayRequest(new XmlElement("urn:ebay:apis:eBLBaseComponents"));
        ebay.add(new RequesterCredential(token));
        ebay.setCreateTimeFrom("2015-12-01T20:34:44.000Z");
        ebay.setCreateTimeTo("2016-12-30T20:34:44.000Z");
        XStream xstream = new XStream();
        xstream.alias("GetOrdersRequest", EbayRequest.class);
        xstream.alias("RequesterCredentials", RequesterCredential.class);
        xstream.addImplicitCollection(EbayRequest.class, "RequesterCredentials");
        xstream.useAttributeFor(EbayRequest.class, "xmlns");
        xstream.registerConverter(new Converter());

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xstream.toXML(ebay);

        System.out.println("XML!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+xml);

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(xml);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'POST' request to URL : " + sandBoxUrl);
        //System.out.println("Post parameters : " + xml);
        System.out.println("Response Code : " + responseCode);

        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String result = response.toString();
            System.out.println(result);

            try {
                try {
                    JSONObject xmlJsonObj = XML.toJSONObject(result);

                    Map<String, Object> json = xmlJsonObj.toMap();
                    log.info("xml to map JSON = "+json);

                    Map<String, Object> getOrdersResponse =
                            (Map<String, Object>) json.get("GetOrdersResponse");
                    log.info("map.get getOrdersResponse = "+getOrdersResponse);
                    log.info("key = "+getOrdersResponse.keySet());

                    Map<String, Object> orderArray =
                            (Map<String, Object>) getOrdersResponse.get("OrderArray");
                    log.info("map.get orderArray = "+orderArray);

                    List<Map<String, Object>> orders = (List<Map<String, Object>>) orderArray.get("Order");
                    for (Map<String, Object> order : orders){
                        log.info("order = "+order);
                        log.info("orderid = "+order.get("OrderID"));
                        order.put("_id", order.get("ExtendedOrderID"));
                        log.info("order list:"+order);
                        mongoOperations.save(order,"eBay");

                        //vo += order.toString()+"\n\n\n\n";
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
package com.wise.csv.cron;

import com.wise.cfg.ThrdCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Project : demo
 * Package : com.wise.test
 * FileName : test
 * Date : 16. 12. 23
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@PropertySource(value = "classpath:application.properties")
@Service
public class ebay {

    private Logger log = LoggerFactory.getLogger(ebay.class);

    private static Environment environment;

    @Scheduled(cron = "*/5 * * * * *")
    public void apiRequest() throws Exception {

        System.out.println("\nTesting 2 - Send Http POST request");

        ApplicationContext context = new AnnotationConfigApplicationContext(ThrdCfg.class);
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");

        int cnt = 0;
        //TODO for문 수정 필요
        for(int i = 0; i < 100; i++){//TODO 임시 for 문
            String mbrNo = "1019";
            String mbrSto = "123123";


            ThrdRun run = (ThrdRun) context.getBean("thrdRun");
            run.setName("Thread "+(cnt++));
            run.setMbrNo(mbrNo);
            run.setMbrSto(mbrSto);
            taskExecutor.execute(run);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

//    // HTTP POST request
//    private void sendPost(String mbrNo, String mbrSto, String token, String AppId, String DevId, String CertId) throws Exception {
//
//        String sandBoxUrl = "https://api.sandbox.ebay.com/ws/api.dll";
//        //TODO Change Url to Real => String realUrl = "https://api.ebay.com/ws/api.dll";
//        URL obj = new URL(sandBoxUrl);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add reuqest header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Content-Type", "text/xml");
//        con.setRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL", "967");
//        con.setRequestProperty("X-EBAY-API-CALL-NAME", "GetOrders");
//        con.setRequestProperty("X-EBAY-API-SITEID", "0");
//        con.setRequestProperty("X-EBAY-API-APP-NAME", AppId);
//        con.setRequestProperty("X-EBAY-API-DEV-NAME", DevId);
//        con.setRequestProperty("X-EBAY-API-CERT-NAME", CertId);
//
//        //Create XML to send data as POST
//        EbayRequest ebay = new EbayRequest(new XmlElement("urn:ebay:apis:eBLBaseComponents"));
//        ebay.add(new RequesterCredential(token));
//        ebay.setCreateTimeFrom("2015-12-01T20:34:44.000Z");
//        ebay.setCreateTimeTo("2016-12-30T20:34:44.000Z");
//        XStream xstream = new XStream();
//        xstream.alias("GetOrdersRequest", EbayRequest.class);
//        xstream.alias("RequesterCredentials", RequesterCredential.class);
//        xstream.addImplicitCollection(EbayRequest.class, "RequesterCredentials");
//        xstream.useAttributeFor(EbayRequest.class, "xmlns");
//        xstream.registerConverter(new Converter());
//
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xstream.toXML(ebay);
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(xml);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//
//        if (responseCode == 200) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            //print result
//            String result = response.toString();
//            System.out.println(result);
//
//            try {
//                JSONObject xmlJsonObj = XML.toJSONObject(result);
//
//                Map<String, Object> json = xmlJsonObj.toMap();
//
//                Map<String, Object> getOrdersResponse =
//                        (Map<String, Object>) json.get("GetOrdersResponse");
//
//                Map<String, Object> orderArray =
//                        (Map<String, Object>) getOrdersResponse.get("OrderArray");
//
//                List<Map<String, Object>> orders = (List<Map<String, Object>>) orderArray.get("Order");
//                for (Map<String, Object> order : orders) {
//                    Map<String, Object> extTrans = (Map<String, Object>) order.get("ExternalTransaction");
//                    order.put("type", "API");
//                    order.put("mbr_no", mbrNo);
//                    order.put("mbr_sto_no", mbrSto);
//
//                    StringBuilder stringBuilder = new StringBuilder();
//                    stringBuilder.append(order.get("OrderID"));
//                    stringBuilder.append("-");
//                    stringBuilder.append(extTrans.get("ExternalTransactionID"));
//                    order.put("_id", stringBuilder.toString());
//                    mongoOperations.save(order, "eBay_api");
//
//                    //vo += order.toString()+"\n\n\n\n";
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
}
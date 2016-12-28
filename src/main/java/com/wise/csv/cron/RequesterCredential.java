package com.wise.csv.cron;

import lombok.Data;

/**
 * Project : demo
 * Package : com.wise.test
 * FileName : Token
 * Date : 16. 12. 26
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Data
public class RequesterCredential {

    public RequesterCredential(String token){
        this.eBayAuthToken = token;
    }

    private String eBayAuthToken;
}
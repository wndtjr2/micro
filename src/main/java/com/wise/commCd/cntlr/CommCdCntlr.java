package com.wise.commCd.cntlr;

import com.wise.comm.bean.RespObj;
import com.wise.commCd.model.CommCd;
import com.wise.commCd.svc.CommCdSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Project : cbt.web
 * Package : com.wise.commCd.cntlr
 * FileName : CommCdCntlr
 * Date : 16. 12. 12
 * Author : wisecommerce@bluewisesoft.com
 * Description : write class description here
 */
@Controller
public class CommCdCntlr {

    private Logger logger = LoggerFactory.getLogger(CommCdCntlr.class);

    @Autowired
    private CommCdSvc commCdSvc;

    private RespObj respObj;

    @RequestMapping(value={"/commCdView"}, method = RequestMethod.GET)
    public String createCommCdGet(){

        logger.debug("======================== insertCommCdPageView ========================");

        return "commCd/commCdView";
    }

    @RequestMapping(value={"/commCdView"})
    @ResponseBody
    public Map<String, Object> createCommCdPost(CommCd commCd, Model model){
        respObj = new RespObj();
        logger.info("======================== insertCommCdPageView 1 ========================"+commCd);
        if (commCd!=null){
            String keyCode = commCd.getMasterCd()+commCd.getSubCd();
            logger.info("======================== keyCode ========================"+keyCode);

            commCd.setCommCd(keyCode);
            commCd.setSubCd("");
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = sdf.format(d);
            try {
                d = sdf.parse(now);
            }catch (ParseException e){
            }
            commCd.setRegistrantDtm(d);

            logger.info("======================== insertCommCdPageView 2 ========================"+commCd);
            commCdSvc.saveCommCd(commCd);
            respObj.Success();
            model.addAttribute("success", true);
        }

        logger.info("======================== insertCommCdPageView 3 ========================"+commCd);
        model.addAttribute("edit", false);
        return respObj.getRespMap();
    }


    @RequestMapping(value={"/commCdList"})
    public String CommCdList(Model model, @RequestParam(required = false) CommCd commCd){
        if (commCd==null){
            commCd = new CommCd();
        }
        logger.debug("======================== insertCommCdListView commCd ========================"+commCd);
        List<CommCd> commCds = commCdSvc.listCommCd(commCd);
        logger.debug("======================== insertCommCdListView ========================"+commCds);
        model.addAttribute("commCds", commCds);
        return "commCd/commCdList";
    }

    @RequestMapping(value={"/commCdUpdateView"}, method = RequestMethod.POST)
    public String CommCdUpdate(Model model, @RequestParam String commCdValue){
        if (commCdValue==null){
            return "redirect:/commCdList.view";
        }

        CommCd commCd = new CommCd();
        commCd.setCommCd(commCdValue);
        CommCd newCommCd = commCdSvc.commCdFind(commCd);

        logger.debug("======================== insertCommCdListView ========================"+newCommCd);
        model.addAttribute("commCd", newCommCd);
        model.addAttribute("edit", true);
        return "commCd/commCdView";
    }

    @RequestMapping(value={"/commCdUpdate"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> CommCdUpdatePost(CommCd commCd, Model model){
        respObj = new RespObj();
        logger.info("======================== insertCommCdPageView 1 ========================"+commCd);
        if (commCd!=null){

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = sdf.format(d);
            try {
                d = sdf.parse(now);
            }catch (ParseException e){
            }
            commCd.setModifierDtm(d);

            logger.info("======================== insertCommCdPageView 2 ========================"+commCd);
            commCdSvc.commCdUpdate(commCd);
            respObj.Success();
            model.addAttribute("success", true);
        }

        logger.info("======================== insertCommCdPageView 3 ========================"+commCd);
        return respObj.getRespMap();
    }
    @RequestMapping(value={"/commCdDelete"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> CommCdDeletePost(CommCd commCd, Model model){
        respObj = new RespObj();
        logger.info("======================== insertCommCdPageView 1 ========================"+commCd);
        if (commCd!=null){
            CommCd newCommCd = commCdSvc.commCdFind(commCd);
            logger.info("======================== insertCommCdPageView 2 ========================"+newCommCd);
            commCdSvc.deleteCommCd(newCommCd);
            respObj.Success();
        }
        logger.info("======================== insertCommCdPageView 3 ========================");
        model.addAttribute("edit", false);
        return respObj.getRespMap();
    }
}
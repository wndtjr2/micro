package com.wise.commCd.svc;

import com.wise.commCd.model.CommCd;

import java.util.List;

/**
 * Created by wisecommerce on 16. 12. 12.
 */
public interface CommCdSvc {

    void saveCommCd(CommCd commCd);

    List<CommCd> listCommCd(CommCd commCd);

    CommCd commCdFind(CommCd commCd);

    void commCdUpdate(CommCd commCd);

    void deleteCommCd(CommCd commCd);

}

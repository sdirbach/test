package org.talend.esb.bundle2;

import beans.CommonLoggingBean;

public class Bundle2 {

    public Bundle2() {
    
    }

    public void init() {
        CommonLoggingBean.logMessage("log from Bundle2");
    }
}

package org.talend.esb.bundle1;

import beans.CommonLoggingBean;

public class Bundle1 {

    public Bundle1() {
    
    }

    public void init() {
        CommonLoggingBean.logMessage("log from Bundle1");
    }
}

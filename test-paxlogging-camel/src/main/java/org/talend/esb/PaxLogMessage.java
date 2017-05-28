package org.talend.esb;

import org.apache.camel.Message;

public interface PaxLogMessage extends Message {

    void setLogMsg(String msg);
    
    String getLogMsg();
}

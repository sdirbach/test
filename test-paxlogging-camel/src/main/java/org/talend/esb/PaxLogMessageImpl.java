package org.talend.esb;

import java.io.Serializable;
import org.apache.camel.impl.DefaultMessage;

public class PaxLogMessageImpl extends DefaultMessage implements Serializable, PaxLogMessage {

    String msg = "";

    public void setLogMsg(String msg) {
        this.msg = msg;
    }
    
    public String getLogMsg() {
        return this.msg;
    }
    
    public String toString() {
        return this.msg;
    }

}

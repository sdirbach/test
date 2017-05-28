package org.talend.esb;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.ops4j.pax.logging.spi.PaxLoggingEvent;

public class PaxLogProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        PaxLoggingEvent event = exchange.getIn().getBody(PaxLoggingEvent.class);
        event.getProperties();
        //PaxLogMessage paxlogMessage = new PaxLogMessageImpl();
        //paxlogMessage.setLogMsg(event.getMessage());
        String logMsg = event.getMessage() + "\n";
        InputStream in = new ByteArrayInputStream(logMsg.getBytes());
        
        exchange.getIn().setBody(in);
    }

}

package org.talend.esb;

import org.ops4j.pax.logging.spi.PaxAppender;
import org.ops4j.pax.logging.spi.PaxLoggingEvent;

public class PaxLogAppender implements PaxAppender {

    public void doAppend( PaxLoggingEvent event ) {
        System.out.println("*************** " + event.getMessage());
    }
}

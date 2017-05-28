package org.talend.esb;

import java.util.Dictionary;
import java.util.Hashtable;

import org.ops4j.pax.logging.spi.PaxAppender;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private ServiceRegistration registration;
    
    public void start(BundleContext context) throws Exception {
        PaxLogAppender esbAppender = new PaxLogAppender();
        Dictionary<String, String> props = new Hashtable<String, String>();
        props.put("org.ops4j.pax.logging.appender.name", "esblog");
        registration = context.registerService(PaxAppender.class, esbAppender, props);
        
    }

    public void stop(BundleContext context) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
    }


}

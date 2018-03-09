package org.talend.esb.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class MyRouteBuilder extends RouteBuilder {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
    }

    public void configure() {
        CamelContext camelContext = getContext();
        org.apache.camel.impl.SimpleRegistry registry = new org.apache.camel.impl.SimpleRegistry();
		org.apache.camel.impl.CompositeRegistry compositeRegistry = new org.apache.camel.impl.CompositeRegistry();
		compositeRegistry.addRegistry(camelContext.getRegistry());
		compositeRegistry.addRegistry(registry);
		((org.apache.camel.impl.DefaultCamelContext) camelContext)
				.setRegistry(compositeRegistry);

        onException(java.lang.RuntimeException.class)
		.routeId("FD_Multicast_cOnException_1")
				.to("log:FD_Multicast.cLog_2" + "?level=WARN");
                
		errorHandler(loggingErrorHandler().logName("abc").level(
				org.apache.camel.LoggingLevel.INFO));
        
		from("direct:direct1").routeId("FD_Multicast_cDirect_1")
				.process(new org.apache.camel.Processor() {
					public void process(org.apache.camel.Exchange exchange)
							throws Exception {
						exchange.getIn().setBody("direct1");
					}

				}).id("FD_Multicast_cProcessor_2");
		from("direct:direct2").routeId("FD_Multicast_cDirect_2")
				.process(new org.apache.camel.Processor() {
					public void process(org.apache.camel.Exchange exchange)
							throws Exception {
						exchange.getIn().setBody("direct2");
					}

				}).id("FD_Multicast_cProcessor_3");
                
		from("timer:cTimer_1" + "?repeatCount=" + 1 + "&delay=" + 1000)
				.routeId("FD_Multicast_cTimer_1")
				.process(new org.apache.camel.Processor() {
					public void process(org.apache.camel.Exchange exchange)
							throws Exception {
						exchange.getIn().setBody("main");
					}

				})
				.id("FD_Multicast_cProcessor_1")
				.multicast(new beans.FD_MulticastAggregator())
				.parallelProcessing()
                .shareUnitOfWork()
				.stopOnException()
				.stopOnAggregateException()
				.to("direct:direct1", "direct:direct2");

    }

}

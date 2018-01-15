package org.talend.esb.eventlogging.sender.rest;

import java.util.List;
import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultMessage;
import org.apache.cxf.message.MessageContentsList;
import org.talend.esb.eventlogging.sender.rest.LogEventImpl;
import org.talend.esb.eventlogging.sender.rest.Event;

public class MarshallingPreparationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		List<LogEventImpl> events = new ArrayList<LogEventImpl>();
		for (int i = 0; i < 10; i++) {
			LogEventImpl evt = new LogEventImpl();
			evt.setEventUUID(i + "");
			evt.setCategory("Category" + i);
            events.add(evt);
		}
        
		EventList answer = new EventList();
		for (int i = 0; i < events.size(); i++) {
			Event event = new Event();
			event.setEventUUID(events.get(i).getEventUUID());
			event.setCategory(events.get(i).getCategory());
		    answer.add(event);
		}
		
		MessageContentsList msgList = new MessageContentsList();
		msgList.add(answer);

		DefaultMessage msg = new DefaultMessage();
		msg.setBody(msgList);
		exchange.setIn(msg);
	}
}

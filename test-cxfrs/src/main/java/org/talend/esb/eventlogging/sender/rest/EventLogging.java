package org.talend.esb.eventlogging.sender.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/eventlogging")
public interface EventLogging {
	@POST
	@Path("/events")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putEvents(String events);
}

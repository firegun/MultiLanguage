package com.paristravel.rest;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
/**/
@Path("feeds")
public class FeedsRest {

    private Logger LOGGER = Logger.getLogger("FeedsRest");

    @GET
    @Path("journaldugeek")
    public String journaldugeek(@QueryParam("start") String start){
        //http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=1&q=http://feeds2.feedburner.com/LeJournalduGeek

		ResteasyClient client = new ResteasyClientBuilder().build();
        LOGGER.log(Level.INFO, "client is build");
		Response response = client.target("http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=1&q=http://feeds2.feedburner.com/LeJournalduGeek").request().get();
        LOGGER.log(Level.INFO, "request is responded");
        String json = response.readEntity(String.class);
		response.close();

        return json;
    }

}

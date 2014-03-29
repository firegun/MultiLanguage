package com.paristravel.rest;

import com.paristravel.twitter.TwitterUtilities;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michael on 04/03/14.
 */
@Path("twitter")
public class TwitterRest {

    private Logger LOGGER = Logger.getLogger("TwitterRest");

    @Context
    private HttpServletRequest httpRequest;

    @POST
    @Path("oauth")
    public String oAuth(){
        String response = null;
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(TwitterUtilities.KEY, TwitterUtilities.SECRETKEY);

        try {
            RequestToken requestToken = twitter.getOAuthRequestToken();
            httpRequest.getSession().setAttribute("requestToken", requestToken);
            response = requestToken.getAuthenticationURL();
        } catch (TwitterException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        return response;
    }

    @GET
    @Path("homeTimeline")
    @Produces(MediaType.APPLICATION_JSON )
    public List<Status> homeTimeline(@QueryParam("start") String start){
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(TwitterUtilities.KEY, TwitterUtilities.SECRETKEY);

        if(httpRequest.getSession().getAttribute("accessToken") == null)
            return null;

        try {
            AccessToken accessToken = (AccessToken) httpRequest.getSession().getAttribute("accessToken");
            twitter.setOAuthAccessToken(accessToken);
            List<Status> statuses = twitter.getHomeTimeline();
            return statuses;
        } catch (TwitterException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        return null;
    }
}

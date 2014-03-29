package com.paristravel.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michael on 04/03/14.
 */
public class OAuthCallback extends HttpServlet {

    private Logger LOGGER = Logger.getLogger("OAuthCallback");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oauth_token = request.getParameter("oauth_token");
        String oauth_verifier = request.getParameter("oauth_verifier");

        // Vérifier si les différents champs sont présents
        if(oauth_token == null || oauth_verifier == null){
            response.sendRedirect(response.encodeRedirectURL("http://127.0.0.1:8080" + request.getContextPath() + "/welcome"));
            return;
        }

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(TwitterUtilities.KEY, TwitterUtilities.SECRETKEY);
            RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauth_verifier);
            twitter.setOAuthAccessToken(accessToken);
            request.getSession().removeAttribute("requestToken");
            request.getSession().setAttribute("accessToken",accessToken);
        } catch (TwitterException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        finally {
            response.sendRedirect(response.encodeRedirectURL("http://127.0.0.1:8080" + request.getContextPath() + "/welcome"));
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

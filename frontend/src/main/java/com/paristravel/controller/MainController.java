package com.paristravel.controller;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michael on 23/02/14.
 */


@Controller
public class MainController {

    private final Logger LOGGER = Logger.getLogger("MainController");

    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "welcome";
    }
}

package com.isj.isi.Mybank.controller;


import com.isj.isi.Mybank.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    protected final Logger log = LoggerFactory.getLogger(ClientController.class);



    // affichage du dashboard
    @GetMapping
    public ModelAndView getClientRegistrationForm(){

        log.info("GET /dashboard called");
        String viewName= "dashboard/index";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("client",new Client());
        return  new ModelAndView(viewName,model);


    }



}

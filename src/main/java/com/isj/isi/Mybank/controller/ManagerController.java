package com.isj.isi.Mybank.controller;

import com.isj.isi.Mybank.Dto.ClientDto;
import com.isj.isi.Mybank.Dto.ManagerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/register")
public class ManagerController {

    protected final Logger log = LoggerFactory.getLogger(ClientController.class);

    private ManagerDto managerDto;


    @GetMapping("/manager")
    public ModelAndView getClientRegistrationForm(){

        log.info("GET /register/manager called");
        String viewName= "manager/manager-registration-form";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("manager",new ManagerDto());
        return  new ModelAndView(viewName,model);


    }

    // envoie du 1er formulaire au deuxième formulaire
    @PostMapping("/manager")
    public ModelAndView getClientRegistration(@Valid @ModelAttribute("manager") ClientDto clientDto){
        log.info("POST/register/manager called");
        this.managerDto= managerDto;
        RedirectView redirectView= new RedirectView();
        redirectView.setUrl("/register/manager/step-2");
        return  new ModelAndView(redirectView);
    }


    //affichage du 2ème formulaire
    @GetMapping("/manager/step-2")
    public  ModelAndView getUploadForm(){
        log.info("GET /register/manager/step-2 called");
        final String viewName= "manager/manager-registration-step-2";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("client",new ClientDto());
        return  new ModelAndView(viewName,model);
    }


}

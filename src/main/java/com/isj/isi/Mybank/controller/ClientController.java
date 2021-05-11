package com.isj.isi.Mybank.controller;


import com.isj.isi.Mybank.Dto.ClientDto;
import com.isj.isi.Mybank.entity.Client;
import com.isj.isi.Mybank.services.ClientService;
import com.isj.isi.Mybank.services.uploadingfiles.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class ClientController {

    private final Path root1= Paths.get("upload");

    protected final Logger log = LoggerFactory.getLogger(ClientController.class);

    private ClientDto clientDto;


    private ClientService clientService;

    private FilesStorageService filesStorageService;

// affichage du 1er formulaire
    @GetMapping("/client")
    public ModelAndView getClientRegistrationForm(){

        log.info("GET /register/client called");
        String viewName= "client/client-registration-form";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("client",new ClientDto());
        return  new ModelAndView(viewName,model);


    }
// envoie du 1er formulaire au deuxième formulaire
    @PostMapping("/client")
    public ModelAndView getClientRegistration(@Valid @ModelAttribute("client") ClientDto clientDto){
        log.info("POST/register/client called");
        this.clientDto= clientDto;
        RedirectView redirectView= new RedirectView();
        redirectView.setUrl("/register/client/step-2");
        return  new ModelAndView(redirectView);
    }
//affichage du 2ème formulaire
    @GetMapping("/client/step-2")
    public  ModelAndView getUploadForm(){
        log.info("GET /register/client/step-2 called");
        final String viewName= "client/client-registration-step-2";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("client",new ClientDto());
        return  new ModelAndView(viewName,model);
    }


//envoie du 2ème formulaire au 3ème formulaire
@PostMapping("/client/step-3")
    public ModelAndView getFormConditionUse(@Valid @ModelAttribute("client") ClientDto clientDto){

        log.info("POST /register/client/step-3 called");
    this.clientDto= clientDto;
        RedirectView redirectView= new RedirectView();
        redirectView.setUrl("/register/client/step-3");

        return  new ModelAndView(redirectView);

    }


// affichage du 3ème formulaire
    @GetMapping("/client/step-3")
    public ModelAndView getFormConditionUse(){
        log.info("GET /register/client/step-3 called");
        final String viewName= "client/client-registration-step-3";
        Map<String,Object> model= new HashMap<String,Object>();
        model.put("client",new ClientDto());
        return  new ModelAndView(viewName,model);

    }


    // on soumet l'entité client en BD
    @PostMapping("/client/step-final")

    public ModelAndView submitRegistrationTotheBackend(@Valid @ModelAttribute("client") ClientDto clientDto, @RequestParam("cni")MultipartFile cni,
                                                       @RequestParam("photo")MultipartFile photo,@RequestParam("localisation")MultipartFile localisation){

        log.info("POST/register/client/step-2 called");

        if (Files.exists(this.root1.resolve(cni.getOriginalFilename())) == false) {
            filesStorageService.save(cni);
        }

        if (Files.exists(this.root1.resolve(photo.getOriginalFilename())) == false) {
            filesStorageService.save(photo);
        }

        if (Files.exists(this.root1.resolve(localisation.getOriginalFilename())) == false) {
            filesStorageService.save(localisation);
        }


        this.clientDto= clientDto;
        try{
            final Client client = clientService.createClient(clientDto);

            RedirectView redirectView= new RedirectView();
            redirectView.setUrl("/condition-utilization");
            return  new ModelAndView(redirectView);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("client/client-registration-step-2");
    }


}

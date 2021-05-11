package com.isj.isi.Mybank.services;

import com.isj.isi.Mybank.Dto.ClientDto;
import com.isj.isi.Mybank.config.MyBankProperties;
import com.isj.isi.Mybank.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ClientService {

    public final Logger log = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private MyBankProperties properties;
    @Autowired
    private RestTemplate restTemplate;



    public Client createClient(ClientDto clientDto) throws Exception{
        //log.info(JsonUtil.getJson(createDto));
        final HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(properties.getBackendHost()+"/register/company");
        final URI url = builder.build().toUri();

        final HttpEntity<ClientDto> requestEntity = new HttpEntity<>(clientDto, requestHeaders);

        try {
            final ResponseEntity<Client> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                    Client.class);
            final String jwtToken = response.getHeaders().get("Authorization").get(0);
            //session.setToken(jwtToken);
           // SecurityUtils.updateSecurityContextUser(jwtToken);
            final Client client = response.getBody();
            //session.setCurrentCompany(client);
            return client;
        }
        catch (Exception e) {
            throw new Exception(e);
        }

    }

}

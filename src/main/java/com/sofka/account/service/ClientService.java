package com.sofka.account.service;

import com.sofka.account.model.Client;
import com.sofka.account.model.Parameter;
import com.sofka.account.service.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
    @Autowired
    private ApplicationService applicationService;

    public Client getClientByUsername(String username) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Parameter parameter = restTemplate.getForObject(
                    applicationService.getServerName()
                            .concat(applicationService.getApiParameter())
                            .concat(Constant.BY_CODE)
                            .concat(Constant.API_CLIENT),
                    Parameter.class
            );
            Client client = restTemplate.getForObject(
                    parameter.getValue()
                            .concat(Constant.BY_USERNAME)
                            .concat(username),
                    Client.class
            );
            return client;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}

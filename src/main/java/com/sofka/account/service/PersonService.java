package com.sofka.account.service;

import com.sofka.account.model.Parameter;
import com.sofka.account.model.Person;
import com.sofka.account.service.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
    @Autowired
    private ApplicationService applicationService;

    public Person getPersonByClientId(String clientId) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Parameter parameter = restTemplate.getForObject(
                    applicationService.getServerName()
                            .concat(applicationService.getApiParameter())
                            .concat(Constant.BY_CODE)
                            .concat(Constant.API_PERSON),
                    Parameter.class);
            Person person = restTemplate.getForObject(
                    parameter.getValue()
                            .concat(Constant.BY_CLIENT_ID)
                            .concat(clientId),
                    Person.class);
            return person;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

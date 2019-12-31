package org.kd.springboot.springrest.demo.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.springboot.springrest.demo.client.CommonUtility;
import org.kd.springboot.springrest.demo.client.config.RestTemplateConfig;
import org.kd.springboot.springrest.demo.server.CountryDemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {CountryDemoApplication.class, RestTemplateConfig.class})
@ExtendWith(SpringExtension.class)
public class CommunicationTest {

    @Autowired
    CommonUtility commonUtility;

    @Test
    public void test(){
        commonUtility.processHttpRequest(HttpMethod.GET, "", "http://localhost", MediaType.APPLICATION_JSON.getType());////TODO
    }

}

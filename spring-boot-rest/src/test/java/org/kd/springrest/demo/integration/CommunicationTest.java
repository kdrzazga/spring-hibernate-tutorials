package org.kd.springrest.demo.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.springrest.demo.client.CommonUtility;
import org.kd.springrest.demo.client.config.RestTemplateConfig;
import org.kd.springrest.demo.server.CountryDemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {CountryDemoApplication.class, RestTemplateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CommunicationTest {

    @Autowired
    CommonUtility commonUtility;

    @Test
    public void test(){
        commonUtility.processHttpRequest(HttpMethod.GET, "", "http://localhost", MediaType.APPLICATION_JSON.getType());////TODO
    }

}

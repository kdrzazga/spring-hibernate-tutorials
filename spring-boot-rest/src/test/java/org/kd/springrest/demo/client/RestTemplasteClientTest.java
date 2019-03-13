package org.kd.springrest.demo.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.springrest.demo.client.config.RestTemplateConfig;
import org.kd.springrest.demo.server.CountryDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestTemplateConfig.class)

public class RestTemplasteClientTest {
    private String serviceAddress = "http://localhost:8083";
    private HttpMethod requestType;
    private String requestAsString;
    private String requestUrl;
    private String responseStatusCode;
    private String responseBody;
    Logger log = LoggerFactory.getLogger(RestTemplasteClientTest.class);

    @Autowired
    private CommonUtility commonUtility;// = new CommonUtility();

    @Test
    public void smokeTest(){
        assertNotNull(commonUtility);
    }

    @Test
    public void test(){
        requestType = HttpMethod.valueOf("GET");
        requestUrl = serviceAddress.concat("/countries");
        requestAsString = "";

        ResponseEntity<String> response = commonUtility.processHttpRequest(requestType, requestAsString, requestUrl, "application/json");
        retrieveResponseBodyAndStatusCode(response);

        Assert.assertEquals(200, responseStatusCode);
        Assert.assertTrue(responseBody.contains("Poland"));
        Assert.assertTrue(responseBody.contains("Germany"));
    }

    private void retrieveResponseBodyAndStatusCode(ResponseEntity<String> response) {
        if (response != null) {
            int responseStatusCodeNumber = response.getStatusCodeValue();
            responseStatusCode = "" + responseStatusCodeNumber;
            responseBody = response.getBody();
            log.info("Status code: " + responseStatusCode);
        } else {
            responseStatusCode = commonUtility.getErrorResponseStatusCode();
            responseBody = commonUtility.getErrorResponseBody();
            log.info("Status code: " + responseStatusCode);
        }
    }
}

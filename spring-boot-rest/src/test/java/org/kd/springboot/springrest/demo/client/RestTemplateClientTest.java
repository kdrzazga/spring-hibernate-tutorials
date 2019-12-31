package org.kd.springboot.springrest.demo.client;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestTemplateClientTest {

    private String serviceAddress = "http://localhost:8083";
    private HttpMethod requestType;
    private String requestAsString;
    private String requestUrl;
    private String responseStatusCode;
    private String responseBody;
    Logger log = LoggerFactory.getLogger(RestTemplateClientTest.class);

    @Autowired
    private CommonUtility commonUtility;// = new CommonUtility();

    @Test
    public void smokeTest() {
        assertNotNull(commonUtility);
    }

    @Test
    public void test() {
        requestType = HttpMethod.valueOf("GET");
        requestUrl = serviceAddress.concat("/countries");
        requestAsString = "";

        ResponseEntity<String> response = commonUtility.processHttpRequest(requestType, requestAsString, requestUrl, "application/json");
        retrieveResponseBodyAndStatusCode(response);

        assertEquals("200", responseStatusCode);
        assertTrue(responseBody.contains("Poland"));
        assertTrue(responseBody.contains("Germany"));
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

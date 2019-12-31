package org.kd.springboot.springrest.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.springboot.springrest.demo.client.CommonUtility;
import org.kd.springboot.springrest.demo.client.RestTemplateClientTest;
import org.kd.springboot.springrest.demo.server.config.RestTemplateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(RestTemplateConfig.class)
@ExtendWith(SpringExtension.class)
public class TttControllerTest {
    Logger log = LoggerFactory.getLogger(RestTemplateClientTest.class);
    private String serviceAddress = "http://localhost:8083";
    private HttpMethod requestType;
    private String requestAsString;
    private String requestUrl;
    private String responseStatusCode;
    private String responseBody;
    @Autowired
    private CommonUtility commonUtility;// = new CommonUtility();

    @Test
    public void testEndpointSendMove(){
        requestType = HttpMethod.valueOf("POST");
        requestUrl = serviceAddress.concat("/sendMove");
        requestAsString = "{\"x\":\"1\", \"y\":\"1\", \"move\":\"O\"}";

        ResponseEntity<String> response = commonUtility.processHttpRequest(requestType, requestAsString, requestUrl, "application/json");
        retrieveResponseBodyAndStatusCode(response);

        assertEquals("200", responseStatusCode);
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

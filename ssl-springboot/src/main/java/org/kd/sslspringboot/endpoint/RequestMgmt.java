package org.kd.sslspringboot.endpoint;

import org.kd.sslspringboot.main.SslApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RequestMgmt {

    @GetMapping("/hello")
    public ResponseEntity<String> getQuotation() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello my friend.");
    }

    @PostMapping("/stop")
    public void stopApplication() {
        SslApp.getContext().stop();
        SslApp.getContext().close();
    }

}

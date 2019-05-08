package org.kd.springsecurity.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Hello {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello!<br/>"
                + "No authentication required here<br/>";
    }

    @GetMapping("/helloAuth")
    public String sayHello2(){
        return "HelloAuth<br/>Please check cookies in your browser. Session Cookie should be present from this login. No need" +
                " to enter password again.<br/>"
                + "<a href='http://localhost:8083/logout'>logout</a>";
    }
}

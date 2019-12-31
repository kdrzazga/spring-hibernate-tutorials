package org.kd.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "org.kd.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }

}
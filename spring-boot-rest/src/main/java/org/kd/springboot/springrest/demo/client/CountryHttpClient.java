package org.kd.springboot.springrest.demo.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CountryHttpClient {

    public HttpResponse<String>  request(String endpoint) {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // this is the default
                .build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8083" + endpoint))
                .GET()   // this is the default
                .build();
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (InterruptedException | IOException e){
            return null;
        }

    }
}

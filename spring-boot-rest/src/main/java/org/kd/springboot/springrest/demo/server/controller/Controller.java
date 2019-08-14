package org.kd.springboot.springrest.demo.server.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;

public class Controller {//extended by CountryController

    private final ControllerHelper helper = new ControllerHelper();

    @GetMapping("/response-entity-builder-with-http-headers")
    public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
        var responseHeaders = new HttpHeaders();
        responseHeaders.set("Baeldung-Example-Header",
                "Value-ResponseEntityBuilderWithHttpHeaders");

        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Response with header using ResponseEntity");
    }

    @PostMapping("/simplePost")
    public ResponseEntity<String> sendSimplePostWithHeader(HttpServletRequest request,
                                                           HttpServletResponse response, Model model) {

        var responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        if (!validateRequest(request)) {
            return createErrorResponse(HttpStatus.BAD_REQUEST,
                    "Wrong parameters. Only single parameter 'word' required.");
        }

        var id = this.helper.generateId();
        responseHeaders.set("id", id);
        var path = Paths.get("output.txt");

        var param = request.getParameter("word");

        try (var writer = Files.newBufferedWriter(path)) {
            var savedLine = id + " " + param;
            writer.write(savedLine);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Saved " + savedLine);

        } catch (IOException e) {
            return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, Arrays.stream(e.getStackTrace()).toString());
        }
    }


    @PutMapping("/file")
    public ResponseEntity<BasicFileAttributes> updateArticle(@RequestBody BasicFileAttributes fileInfo) {
        Path file = Paths.get("output.txt");
        BeanUtils.copyProperties(fileInfo, file);

        try {
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            BeanUtils.copyProperties(file, attrs);
            return new ResponseEntity<>(attrs, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private boolean validateRequest(HttpServletRequest request) {
        var params = Collections.list(request.getParameterNames());
        if (params.size() != 1) {
            return false;
        } else {
            return "word".equals(params.get(0));
        }
    }

    private ResponseEntity<String> createErrorResponse(HttpStatus status, String message) {
        var error = "error message " + message;

        return ResponseEntity
                .status(status)
                .body(error);
    }
}
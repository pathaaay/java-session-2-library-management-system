package com.lms.api.controller;

import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "ok";
    }
}

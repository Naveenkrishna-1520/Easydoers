package com.easydoers.employeeservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/{path:[^\\.]*}") // Matches all paths without a period
    public String redirectToFrontend() {
        return "forward:/index.html";
    }
}
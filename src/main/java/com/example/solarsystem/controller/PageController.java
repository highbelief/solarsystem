package com.example.solarsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";  // dashboard.html 렌더링
    }

    @GetMapping("/logs")
    public String logsPage() {
        return "logPage";  // logPage.html 파일을 렌더링
    }
}
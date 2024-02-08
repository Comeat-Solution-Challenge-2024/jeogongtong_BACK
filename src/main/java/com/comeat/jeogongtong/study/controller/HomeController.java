package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.service.StudyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    @GetMapping("/") //홈
    public String index() {
        return "index";
    }

}

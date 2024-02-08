package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final StudyService studyService;
    @GetMapping("/") //홈
    public String index(Model model) {
        List<StudyDto> studyDtoList = studyService.findAll();
        model.addAttribute("studyList", studyDtoList);
        return "index";
    }

}

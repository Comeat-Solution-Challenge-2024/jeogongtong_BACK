package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study-clubs")
public class StudyController {
    private final StudyService studyService;

    @GetMapping("/regist")
    public String registForm() {
        return "regist";
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute StudyDto studyDto) {
        System.out.println("studyDto = " + studyDto);
        studyService.regist(studyDto);
        return "index";
    }
}

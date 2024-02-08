package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "redirect:/"; //홈으로 돌아가기
    }
}


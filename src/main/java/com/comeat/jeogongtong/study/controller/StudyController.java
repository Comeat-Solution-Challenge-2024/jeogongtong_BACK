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
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) { // 전체 목록을 DB로부터 가져와야함
        //DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
        List<StudyDto> studyDtoList = studyService.findAll();
        model.addAttribute("studyList", studyDtoList);
        return "index";
    }
}

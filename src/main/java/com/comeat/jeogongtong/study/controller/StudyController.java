package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String regist(@ModelAttribute StudyDto studyDto, HttpSession session) {
        Long memberId = (Long) session.getAttribute("memberId");
        System.out.println("studyDto = " + studyDto);
        if (memberId == null) {
            System.out.println("로그인 후 스터디 등록이 가능합니다");
            return "redirect:/login";
        }
        studyService.regist(studyDto, memberId);
        return "redirect:/"; //홈으로 돌아가기
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search"; // 검색 폼 페이지로 이동
    }

    @PostMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<StudyDto> studyList = studyService.search(keyword);
        model.addAttribute("studyList", studyList);

        return "search_result"; // 검색 결과 페이지로 이동
    }

    @GetMapping("/apply/{studyId}")
    public String detail(@PathVariable Long studyId, Model model){
        StudyDto studyDto = studyService.findById(studyId);
        model.addAttribute("studyDto",studyDto);
        return"study_apply";
    }
}


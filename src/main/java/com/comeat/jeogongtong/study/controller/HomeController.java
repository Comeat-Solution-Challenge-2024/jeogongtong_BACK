package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import jakarta.servlet.http.HttpSession;
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
    public String index(HttpSession session, Model model) {
        List<StudyDto> studyDtoList = studyService.findAll();
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
        model.addAttribute("studyList", studyDtoList);

        if (loginMember != null) {
            model.addAttribute("member", loginMember); // 뷰로 전달
            System.out.println(loginMember);
        }
        return "index";
    }
}

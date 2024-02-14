package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.service.MemberService;
import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.service.StudyService;
import com.comeat.jeogongtong.study_member.service.StudyMemberService;
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
    private final StudyMemberService studyMemberService;
    private final MemberService memberService;
    @GetMapping("/") //홈
    public String index(HttpSession session, Model model) {
        List<StudyDto> studyDtoList = studyService.findAll();
        Long memberId = (Long) session.getAttribute("memberId");
        if (memberId != null){
            MemberDto loginMember = memberService.findById(memberId);
            if (loginMember != null) {
                List<StudyDto> myStudies = studyMemberService.findMyStudies(loginMember.getMemberId());
                model.addAttribute("myStudy", myStudies); // 내 공부방 목록 전달
                model.addAttribute("member", loginMember);
                System.out.println(loginMember);
            }
        }
        model.addAttribute("studyList", studyDtoList);
        return "index";
    }
}

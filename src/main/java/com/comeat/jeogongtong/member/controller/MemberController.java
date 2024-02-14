package com.comeat.jeogongtong.member.controller;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.service.MemberService;
import com.comeat.jeogongtong.study_member.dto.StudyMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    /* 마이페이지 조회*/
    @GetMapping("/{memberId}")
    public String findById(@PathVariable Long memberId, Model model){
        MemberDto memberDto = memberService.findById(memberId);
        model.addAttribute("member",memberDto);

        //스터디 랭킹 추가
        List<StudyMemberDto> studyRank = memberService.findStudyRankByMemberId(memberId);
        model.addAttribute("studyRank", studyRank);
        return "my_page";
    }
}

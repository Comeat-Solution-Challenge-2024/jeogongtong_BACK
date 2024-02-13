package com.comeat.jeogongtong.member.controller;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/{memberId}")
    public String findById(@PathVariable Long memberId, Model model){
        MemberDto memberDto = memberService.findById(memberId);
        model.addAttribute("member",memberDto);
        return "my_page";
    }
}

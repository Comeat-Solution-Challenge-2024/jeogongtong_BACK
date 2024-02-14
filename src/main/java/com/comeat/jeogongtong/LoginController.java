package com.comeat.jeogongtong;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute MemberDto memberDto, HttpSession session){
        MemberDto loginMember = memberService.login(memberDto);
        if (loginMember != null){
            session.setAttribute("memberId",loginMember.getMemberId());
            System.out.println("로그인에 성공하셨습니다 " + loginMember.getNickname());
            return "redirect:/";
        } else {
            return "login";
        }
    }
}


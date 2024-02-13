package com.comeat.jeogongtong.study.controller;

import com.comeat.jeogongtong.study.dto.MemberDto;
import com.comeat.jeogongtong.study.entity.MemberEntity;
import com.comeat.jeogongtong.study.repository.MemberRepository;
import com.comeat.jeogongtong.study.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult != null){
            session.setAttribute("loginEmail",loginResult.getEmail());
            System.out.println("로그인에 성공하셨습니다" + loginResult.getNickname());
            return "redirect:/";
        } else {
            return "login";
        }
    }
}


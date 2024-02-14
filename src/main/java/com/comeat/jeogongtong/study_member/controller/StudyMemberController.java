package com.comeat.jeogongtong.study_member.controller;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.study_member.service.StudyMemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study-member")
public class StudyMemberController {
    private final StudyMemberService studyMemberService;

    @PostMapping("/apply")
    public String apply(@RequestParam Long studyId, HttpSession session){
        // 세션에서 memberId 가져오기
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
        // 파이어베이스에 맞춰서 변경 필요할 수도
        // loginMember 객체에서 memberId를 가져옴
        if (loginMember != null && loginMember.getMemberId() != null) {
            Long memberId = loginMember.getMemberId();

            studyMemberService.addStudyMember(memberId, studyId);
            System.out.println("스터디 등록이 완료되었습니다!");
            return "redirect:/";
        } else {
            System.out.println("회원 ID가 유효하지 않습니다.");
            return "redirect:/login";
        }
    }
}

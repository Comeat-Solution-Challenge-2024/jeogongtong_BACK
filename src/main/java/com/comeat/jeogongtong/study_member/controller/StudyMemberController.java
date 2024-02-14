package com.comeat.jeogongtong.study_member.controller;

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
        Long memberId = (Long) session.getAttribute("loggedInMemberId"); // 파이어베이스에 맞춰서 변경 필요할 수도
        studyMemberService.addStudyMember(memberId, studyId);
        System.out.println("스터디 등록이 완료되었습니다!");
        return "redirect: /";
    }
}

package com.comeat.jeogongtong.study.service;

import com.comeat.jeogongtong.study.entity.StudyEntity;
//import com.comeat.jeogongtong.study.entity.StudyMemberEntity;
//import com.comeat.jeogongtong.study.repository.StudyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyMemberService {
//    private final StudyMemberRepository studyMemberRepository;

/*
    public List<StudyEntity> getMyStudy(Long memberId){
        List<StudyMemberEntity> studyMemberEntityList = studyMemberRepository.findByMemberId(memberId);

        List<StudyEntity> myStudy = new ArrayList<>();
        for (StudyMemberEntity studyMember : studyMemberEntityList) {
            myStudy.add(studyMember.getStudyEntity());
        }
        return myStudy;
    }*/
}

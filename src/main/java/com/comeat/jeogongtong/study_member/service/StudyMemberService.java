package com.comeat.jeogongtong.study_member.service;

import com.comeat.jeogongtong.member.entity.MemberEntity;
import com.comeat.jeogongtong.member.repository.MemberRepository;
import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.entity.StudyEntity;
import com.comeat.jeogongtong.study.repository.StudyRepository;
import com.comeat.jeogongtong.study_member.entity.StudyMemberEntity;
import com.comeat.jeogongtong.study_member.repository.StudyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //의존성 주입
public class StudyMemberService {
    private final StudyMemberRepository studyMemberRepository;
    private final MemberRepository memberRepository; //MemberEntity를 조회해 스터디 멤버에 등록
    private final StudyRepository studyRepository; //StudyEnetity를 조회해 스터디 멤버에 등록
    public  void addStudyMember(Long memberId, Long studyId) { //스터디 등록
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invailid member ID : " + memberId));
        StudyEntity studyEntity = studyRepository.findById(studyId)
                .orElseThrow(() -> new IllegalArgumentException("Invaild study ID : " + studyId));

        StudyMemberEntity studyMemberEntity = new StudyMemberEntity();
        studyMemberEntity.setMember(memberEntity);
        studyMemberEntity.setStudy(studyEntity);
        studyMemberEntity.setWeektime(Time.valueOf("00:00:00"));
        studyMemberEntity.setRank(null);
        studyMemberEntity.setState("회원");

        studyMemberRepository.save(studyMemberEntity); // 스터디 멤버 DB에 저장
    }

    public List<StudyDto> findMyStudies(Long memberId){
        List<StudyMemberEntity> studyMember = studyMemberRepository.findByMember_MemberId(memberId);
        return studyMember.stream()
                .map(studyMemberEntity -> StudyDto.toStudyDto(studyMemberEntity.getStudy()))
                .collect(Collectors.toList());

    }
}

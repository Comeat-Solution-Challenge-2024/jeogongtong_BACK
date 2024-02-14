package com.comeat.jeogongtong.member.service;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.entity.MemberEntity;
import com.comeat.jeogongtong.member.repository.MemberRepository;
import com.comeat.jeogongtong.study_member.dto.StudyMemberDto;
import com.comeat.jeogongtong.study_member.entity.StudyMemberEntity;
import com.comeat.jeogongtong.study_member.repository.StudyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final StudyMemberRepository studyMemberRepository;
    public MemberDto login(MemberDto memberDto) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDto.getEmail());
        if (byMemberEmail.isPresent()){
            MemberEntity memberEntity = byMemberEmail.get();
            MemberDto loginMember = MemberDto.toMemberDto(memberEntity);
            return loginMember;
        } else return null;
    }

    public MemberDto findById(Long memberId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(memberId);
        if(optionalMemberEntity.isPresent()){
            return MemberDto.toMemberDto(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public Optional<MemberEntity> findMemberEntityById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    /*사용자 스터디 랭킹 조회 -> 마이페이지에 랭킹 출력*/
    public List<StudyMemberDto> findStudyRankByMemberId(Long memberId){
        List<StudyMemberEntity> studyMember = studyMemberRepository.findByMember_MemberId(memberId);
        return studyMember.stream()
                .map(StudyMemberDto::toStudyMemberDto)
                .collect(Collectors.toList());
    }
}

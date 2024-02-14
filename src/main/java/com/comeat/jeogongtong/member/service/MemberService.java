package com.comeat.jeogongtong.member.service;

import com.comeat.jeogongtong.member.dto.MemberDto;
import com.comeat.jeogongtong.member.entity.MemberEntity;
import com.comeat.jeogongtong.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

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
}

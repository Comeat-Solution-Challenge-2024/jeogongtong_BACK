package com.comeat.jeogongtong.study.service;

import com.comeat.jeogongtong.study.dto.MemberDto;
import com.comeat.jeogongtong.study.entity.MemberEntity;
import com.comeat.jeogongtong.study.repository.MemberRepository;
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
            MemberDto dto = MemberDto.toMemberDto(memberEntity);
            return dto;
        } else return null;
    }

    public MemberDto findById(Long member_id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(member_id);
        if(optionalMemberEntity.isPresent()){
            return MemberDto.toMemberDto(optionalMemberEntity.get());
        } else {
            return null;
        }
    }
}

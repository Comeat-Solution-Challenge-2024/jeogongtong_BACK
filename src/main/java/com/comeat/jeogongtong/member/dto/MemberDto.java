package com.comeat.jeogongtong.member.dto;

import com.comeat.jeogongtong.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private Long memberId;
    private String nickname;
    private int point;
    private String tier;
    private String email;

    public static MemberDto toMemberDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberEntity.getMemberId());
        memberDto.setNickname(memberEntity.getNickname());
        memberDto.setPoint(memberEntity.getPoint());
        memberDto.setTier(memberEntity.getTier());
        memberDto.setEmail(memberEntity.getEmail());
        return memberDto;
    }
}

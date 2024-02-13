package com.comeat.jeogongtong.member.dto;

import com.comeat.jeogongtong.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private Long member_id;
    private String nickname;
    private int point;
    private String tier;
    private String email;

    public static MemberDto toMemberDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.setMember_id(memberEntity.getMember_id());
        memberDto.setNickname(memberEntity.getNickname());
        memberDto.setPoint(memberEntity.getPoint());
        memberDto.setTier(memberEntity.getTier());
        memberDto.setEmail(memberEntity.getEmail());
        return memberDto;
    }
}

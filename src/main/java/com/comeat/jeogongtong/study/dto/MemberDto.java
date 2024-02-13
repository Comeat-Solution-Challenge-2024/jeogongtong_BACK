package com.comeat.jeogongtong.study.dto;

import com.comeat.jeogongtong.study.entity.MemberEntity;
import jakarta.persistence.Column;
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
    private String tear;
    private String email;

    public static MemberDto toMemberDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.setNickname(memberEntity.getNickname());
        memberDto.setPoint(memberEntity.getPoint());
        memberDto.setTear(memberEntity.getTear());
        memberDto.setEmail(memberEntity.getEmail());
        return memberDto;
    }
}

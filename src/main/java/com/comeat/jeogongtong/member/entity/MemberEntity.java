package com.comeat.jeogongtong.member.entity;

import com.comeat.jeogongtong.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column
    private String nickname;
    @Column
    private int point;
    @Column
    private String tier;
    @Column
    private String email;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname(memberDto.getNickname());
        memberEntity.setPoint(memberDto.getPoint());
        memberEntity.setTier(memberDto.getTier());
        memberEntity.setEmail(memberDto.getEmail());
        return memberEntity;
    }
}

package com.comeat.jeogongtong.study.entity;

import com.comeat.jeogongtong.study.dto.MemberDto;
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
    private Long member_id;
    @Column
    private String nickname;
    @Column
    private int point;
    @Column
    private String tear;
    @Column
    private String email;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname(memberDto.getNickname());
        memberEntity.setPoint(memberDto.getPoint());
        memberEntity.setTear(memberDto.getTear());
        memberEntity.setEmail(memberDto.getEmail());
        return memberEntity;
    }
}

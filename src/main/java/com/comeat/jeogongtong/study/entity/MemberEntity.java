package com.comeat.jeogongtong.study.entity;

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
}

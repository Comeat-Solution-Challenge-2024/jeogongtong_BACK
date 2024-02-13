/*
package com.comeat.jeogongtong.study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "study_member")
public class StudyMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_member_id")
    private Long studyMemberId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "study_id")
    private Long studyId;

    @Column(name = "weektime")
    private Timestamp weektime;

    @Column(name = "rank")
    private String rank;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "study_id", referencedColumnName = "studyId")
    private StudyEntity studyEntity;
}
*/

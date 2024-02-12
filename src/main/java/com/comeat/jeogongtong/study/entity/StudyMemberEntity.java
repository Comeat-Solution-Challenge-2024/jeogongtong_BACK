package com.comeat.jeogongtong.study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "study_member")
public class StudyMemberEntity {
    @EmbeddedId
    private StudyMemberId id;

    @ManyToOne
    @MapsId("studyId")
    @JoinColumn(name = "study_id")
    private StudyEntity studyEntity;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @Column(name = "weektime")
    private Time weektime;

    @Column(name = "rank")
    private String rank;

    @Column(name = "state")
    private String state;
}


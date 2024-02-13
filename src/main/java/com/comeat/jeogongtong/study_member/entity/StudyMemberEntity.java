package com.comeat.jeogongtong.study_member.entity;

import com.comeat.jeogongtong.member.entity.MemberEntity;
import com.comeat.jeogongtong.study.entity.StudyEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "study_member")
@Getter
@Setter
public class StudyMemberEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", insertable = false, updatable = false)
    private MemberEntity member;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id", insertable = false, updatable = false)
    private StudyEntity study; //name = DB내 외래키 컬럼 이름 반영, referencedColumnName은 엔티티의 @Id의 필드이름을 반영

    @Column(name = "weektime")
    private Time weektime;

    @Column(name = "`rank`")
    private String rank;

    @Column(name = "state")
    private String state;
}

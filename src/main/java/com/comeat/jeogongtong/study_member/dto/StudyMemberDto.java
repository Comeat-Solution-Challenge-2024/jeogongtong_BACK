package com.comeat.jeogongtong.study_member.dto;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudyMemberDto{ //외래키 복합키 신경 안써도 괜찮
    private Long memberId;
    private Long studyId;
    private Time weektime;
    private String rank;
    private String state;

}

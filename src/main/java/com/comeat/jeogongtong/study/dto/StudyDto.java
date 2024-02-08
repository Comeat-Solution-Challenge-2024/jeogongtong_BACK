package com.comeat.jeogongtong.study.dto;


import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class StudyDto {
    private Long studyId;
    private String category;
    private String name;
    private String book;
    private int period; // 기한 (일단 int로)
    private int rankerAsk; //질의응답 타입을 int로?
    private int rankerAnswer;
    private String intro;
//    private LocalDateTime studyCreatedTime;
//    private LocalDateTime studyUpdatedTime;

}

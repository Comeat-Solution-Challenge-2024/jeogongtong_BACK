package com.comeat.jeogongtong.study.entity;

import com.comeat.jeogongtong.study.dto.StudyDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "study")
public class StudyEntity extends BaseEntity{
//   DB와 동일한 순서로 설정
    @Id //pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment_auto (숫자 자동 증가)
    @Column(name = "study_id")
    private Long studyId;
    @Column(length = 100,nullable = false)
    private String name;
    @Column
    private String book;

    @Column //nullable = false : 에러발생
    private String category;
    @Column(nullable = false)
    private String settingPeriod;
    @Column
    private int rankerAsk; //질의응답 타입을 int로?
    @Column
    private int rankerAnswer;
    @Column(length = 500)
    private String intro;

    public static StudyEntity tostudyEntity(StudyDto studyDto) {
        StudyEntity studyEntity = new StudyEntity();
        studyEntity.setStudyId(studyDto.getStudyId());
        studyEntity.setName(studyDto.getName());
        studyEntity.setBook(studyDto.getBook());
        studyEntity.setCategory(studyDto.getCategory());
        studyEntity.setSettingPeriod(studyDto.getSettingPeriod());
        studyEntity.setRankerAsk(studyDto.getRankerAsk());
        studyEntity.setRankerAnswer(studyDto.getRankerAnswer());
        studyEntity.setIntro(studyDto.getIntro());

        return studyEntity;
    }
}

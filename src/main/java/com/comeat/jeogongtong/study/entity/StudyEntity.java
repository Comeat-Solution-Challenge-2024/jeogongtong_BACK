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
    @Id //pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment_auto (숫자 자동 증가)
    private Long id;
    @Column(length = 100,nullable = false) //defalut = 크기 : 255, null 가능상태
    private String name;
    @Column
    private String book;

    @Column //nullable = false : 에러발생
    private String category;
    @Column(nullable = false)
    private int period;
    @Column
    private int rankerAsk; //질의응답 타입을 int로?
    @Column
    private int rankerAnswer;
    @Column(length = 500)
    private String inform;


    public static StudyEntity toRegistEntity(StudyDto studyDto) {
        StudyEntity studyEntity = new StudyEntity();
        studyEntity.setName(studyDto.getName());
        studyEntity.setBook(studyDto.getBook());
        studyEntity.setCategory(studyEntity.getCategory());
        studyEntity.setPeriod(studyEntity.getPeriod());
        studyEntity.setRankerAsk(studyDto.getRankerAsk());
        studyEntity.setRankerAnswer(studyEntity.getRankerAnswer());
        studyEntity.setInform(studyEntity.getInform());

        return studyEntity;
    }
}

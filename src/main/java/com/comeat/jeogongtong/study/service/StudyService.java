package com.comeat.jeogongtong.study.service;

//import com.comeat.jeogongtong.study.StudyRepository;
import com.comeat.jeogongtong.study.dto.StudyDto;
import com.comeat.jeogongtong.study.entity.StudyEntity;
import com.comeat.jeogongtong.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


// DtO를 Entity로 Entity를 Dto로 바꿔주는 역할

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyRepository studyRepository; //기능 구현 자체에는 문제 없음

    public void regist(StudyDto studyDto) {
        StudyEntity studyEntity = StudyEntity.toRegistEntity(studyDto);
        studyRepository.save(studyEntity); //자동으로 스터디 레포지토리에 상속
    }
}

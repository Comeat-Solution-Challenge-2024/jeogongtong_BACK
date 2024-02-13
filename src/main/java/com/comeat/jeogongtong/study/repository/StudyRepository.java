package com.comeat.jeogongtong.study.repository;


import com.comeat.jeogongtong.study.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<StudyEntity, Long> {
    List<StudyEntity> findByNameContainingIgnoreCase(String keyword);
}

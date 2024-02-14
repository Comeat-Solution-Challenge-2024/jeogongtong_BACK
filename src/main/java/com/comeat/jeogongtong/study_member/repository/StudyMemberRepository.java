package com.comeat.jeogongtong.study_member.repository;

import com.comeat.jeogongtong.study_member.entity.StudyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<StudyMemberEntity, Long> {
}

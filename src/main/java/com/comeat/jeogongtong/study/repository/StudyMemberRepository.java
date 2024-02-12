package com.comeat.jeogongtong.study.repository;

import com.comeat.jeogongtong.study.entity.StudyMemberEntity;
import com.comeat.jeogongtong.study.entity.StudyMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<StudyMemberEntity, StudyMemberId> {
}

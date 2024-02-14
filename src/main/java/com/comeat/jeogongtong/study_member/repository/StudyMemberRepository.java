package com.comeat.jeogongtong.study_member.repository;

import com.comeat.jeogongtong.study_member.entity.StudyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyMemberRepository extends JpaRepository<StudyMemberEntity, Long> {
    List<StudyMemberEntity> findByMember_MemberId(Long memberId);
}

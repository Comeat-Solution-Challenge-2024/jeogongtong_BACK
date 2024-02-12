package com.comeat.jeogongtong.study.repository;

import com.comeat.jeogongtong.study.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}

package com.comeat.jeogongtong.study.repository;


import com.comeat.jeogongtong.study.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends JpaRepository<StudyEntity, Long> {

    // update board_table set board_hits=board_hits+1 where id=?
//    @Modifying
//    @Query(value = "update StudyEntity b set b.studyHits=b.studyHits+1 where b.id=:id")
//    void updateHits(@Param("id") Long id);

}

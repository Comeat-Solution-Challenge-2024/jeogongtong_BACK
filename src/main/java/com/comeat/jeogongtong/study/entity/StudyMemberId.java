package com.comeat.jeogongtong.study.entity;

import jakarta.persistence.Embeddable;
import lombok.*;


//import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudyMemberId implements Serializable {

    private Long studyId;

    private Long memberId;

    // equals 및 hashCode 오버라이딩
}


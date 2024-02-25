package com.comeat.jeogongtong.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answers{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String category;
    private String regiDate;
    private String photoUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "asking_id")
    private Questions questions;
}
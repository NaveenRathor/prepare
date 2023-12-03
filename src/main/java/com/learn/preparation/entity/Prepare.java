package com.learn.preparation.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prepare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;

}

package com.avanire.springrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

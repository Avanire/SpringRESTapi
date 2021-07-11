package com.avanire.springrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todoEntityList;
}

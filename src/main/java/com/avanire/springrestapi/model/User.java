package com.avanire.springrestapi.model;

import com.avanire.springrestapi.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private List<TodoModel> todoList;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodoList(entity.getTodoEntityList().stream().map(TodoModel::toModel).collect(Collectors.toList()));
        return model;
    }
}

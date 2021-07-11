package com.avanire.springrestapi.model;

import com.avanire.springrestapi.entity.TodoEntity;
import com.avanire.springrestapi.repository.TodoRepo;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TodoModel {
    private Long id;
    private String title;
    private Boolean completed;

    public static TodoModel toModel(TodoEntity entity) {
        TodoModel model = new TodoModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.getCompleted());
        return model;
    }
}

package com.avanire.springrestapi.service;

import com.avanire.springrestapi.entity.TodoEntity;
import com.avanire.springrestapi.entity.UserEntity;
import com.avanire.springrestapi.model.TodoModel;
import com.avanire.springrestapi.repository.TodoRepo;
import com.avanire.springrestapi.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepo todoRepo;
    private UserRepo userRepo;

    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public TodoModel createTodo(TodoEntity todo, Long id) {
        UserEntity user = userRepo.findById(id).get();
        todo.setUser(user);
        return TodoModel.toModel(todoRepo.save(todo));
    }

    public TodoModel complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return TodoModel.toModel(todoRepo.save(todo));
    }
}

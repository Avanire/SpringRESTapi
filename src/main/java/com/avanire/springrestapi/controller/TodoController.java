package com.avanire.springrestapi.controller;

import com.avanire.springrestapi.entity.TodoEntity;
import com.avanire.springrestapi.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(service.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

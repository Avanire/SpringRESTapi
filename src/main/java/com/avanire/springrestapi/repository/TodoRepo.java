package com.avanire.springrestapi.repository;

import com.avanire.springrestapi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}

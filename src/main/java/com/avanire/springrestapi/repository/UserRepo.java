package com.avanire.springrestapi.repository;

import com.avanire.springrestapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

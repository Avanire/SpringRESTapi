package com.avanire.springrestapi.service;

import com.avanire.springrestapi.entity.UserEntity;
import com.avanire.springrestapi.exception.UserAlreadyExistException;
import com.avanire.springrestapi.exception.UserNotFoundException;
import com.avanire.springrestapi.model.User;
import com.avanire.springrestapi.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Такой пользователь уже существует");
        }

        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();

        if (userEntity == null) {
            throw new UserNotFoundException("Пользователь с таким ID не найден");
        }

        return User.toModel(userEntity);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}

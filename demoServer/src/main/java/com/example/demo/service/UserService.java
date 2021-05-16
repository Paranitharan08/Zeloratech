package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity addUser(Object User);

    public ResponseEntity getAllUser();

    public ResponseEntity<Object> findUserById(Integer id);
}

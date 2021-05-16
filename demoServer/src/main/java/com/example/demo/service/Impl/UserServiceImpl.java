package com.example.demo.service.Impl;

import com.example.demo.exception.CustomErrorResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    ObjectMapper mapper = new ObjectMapper();

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseEntity addUser(Object user) {
        try {
            User obj = mapper.convertValue(user, User.class);
            user = userRepo.save(obj);
            LOG.info("Adding new User is successful");
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Error : " + e.getMessage());
            e.printStackTrace();
            CustomErrorResponse errors = new CustomErrorResponse();
            errors.setError("Unknown error");
            return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public ResponseEntity getAllUser(){
        try{
            List<User> userList = userRepo.findAll();
            LOG.info("Getting all the users");
            return new ResponseEntity<Object>(userList ,HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Error : "+e.getMessage());
            e.printStackTrace();
            CustomErrorResponse errors = new CustomErrorResponse();
            errors.setError("Unknown error");
            return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public ResponseEntity<Object> findUserById(Integer id){
        try{
            Optional<User> UserList = userRepo.findById(id);
            LOG.info("Getting user by Id");
            return new ResponseEntity<Object>(UserList ,HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Error : "+e.getMessage());
            e.printStackTrace();
            CustomErrorResponse errors = new CustomErrorResponse();
            errors.setError("Unknown error");
            return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}

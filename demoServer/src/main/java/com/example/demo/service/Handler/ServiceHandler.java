package com.example.demo.service.Handler;

import com.example.demo.service.UserService;
import com.example.demo.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ServiceHandler {

    @Autowired
    UserService userService;

    public ResponseEntity handleServiceRequest(String reqId, Object obj, Integer id) {
        switch (Integer.parseInt(reqId)) {

            case CommonConstants.ADD_USER:
                return addUser(obj);
            case CommonConstants.GET_ALL_USER:
                return getAllUser();
            case CommonConstants.GET_USER_BY_ID:
                return getUSerById(id);

            default:
                return new ResponseEntity("Failed", HttpStatus.OK);

        }
    }

    //Users
    private ResponseEntity addUser(Object user) {return userService.addUser(user);}

    private ResponseEntity getAllUser() {return userService.getAllUser();}

    private ResponseEntity getUSerById(Integer id) {return userService.findUserById(id);}

}

package com.example.demo.controller;

import com.example.demo.service.Handler.ServiceHandler;
import com.example.demo.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = CommonConstants.ORIGINS, allowedHeaders = CommonConstants.ALLOWED_HEADERS)
@RestController
@RequestMapping(CommonConstants.MAPPING_MAIN)

public class MainController {

    @Autowired
    ServiceHandler serviceHandler;

    @GetMapping("/data")
    public ResponseEntity getData(@RequestParam(value = "RT") String reqTyp, @RequestParam(value = "Id", defaultValue = "") Integer id) {
        return serviceHandler.handleServiceRequest(reqTyp, new Object(), id);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity getData(@PathVariable Integer id,@RequestParam(value = "RT") String reqTyp) {
        return serviceHandler.handleServiceRequest(reqTyp, new Object(), id);
    }

    @PostMapping("/data/{RT}")
    public ResponseEntity postData(@PathVariable(value = "RT") String reqTyp,@RequestBody Object obj) {
        return serviceHandler.handleServiceRequest(reqTyp, obj,0);
    }

    @DeleteMapping("/data")
    public ResponseEntity deleteData(@RequestParam(value = "RT") String reqTyp, @RequestParam(value = "Id", defaultValue = "") Integer id) {
        return serviceHandler.handleServiceRequest(reqTyp,null,id);
    }
}

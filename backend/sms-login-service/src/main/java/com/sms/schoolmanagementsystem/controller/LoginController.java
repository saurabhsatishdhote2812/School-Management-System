package com.sms.schoolmanagementsystem.controller;

import com.sms.schoolmanagementsystem.model.LoginRequest;
import com.sms.schoolmanagementsystem.service.UserValidateService;
import com.sms.schoolmanagementsystem.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sms")
public class LoginController {

    @Autowired
    UserValidateService userValidateService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.info(Utility.REQUEST_RECEIVED + "/login");
        var result = userValidateService.checkUserAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        log.info(Utility.RESPONSE_SENT);
        return ResponseEntity.ok(result);
    }

}

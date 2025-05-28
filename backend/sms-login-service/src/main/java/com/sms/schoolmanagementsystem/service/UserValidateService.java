package com.sms.schoolmanagementsystem.service;

import com.sms.schoolmanagementsystem.dao.UserValidate;
import com.sms.schoolmanagementsystem.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserValidateService {

    @Autowired
    UserValidate userValidate;

    public String checkUserAndPassword(String username, String password) {
        log.info(Utility.QUERY_EXECUTION_STARTED);
        var result = userValidate.checkUserAndPass(username, password).equals("1") ? Utility.USERNAME_VALIDATE_PASS : Utility.USERNAME_VALIDATE_FAIL;
        log.info(Utility.QUERY_EXECUTION_COMPLETED);
        return result;
    }

}

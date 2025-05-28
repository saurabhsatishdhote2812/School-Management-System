package com.sms.schoolmanagementsystem.controller;

import com.mysql.cj.util.Util;
import com.sms.schoolmanagementsystem.exception.SubjectNotFoundException;
import com.sms.schoolmanagementsystem.service.GetSubjectByGradeService;
import com.sms.schoolmanagementsystem.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sms")
public class GetSubjectByGradeController{

    @Autowired
    GetSubjectByGradeService getSubjectByGradeService;

    @GetMapping(value = "/subject/{grade}")
    public ResponseEntity<List<String>> getSubjectByGradeController(@PathVariable String grade) throws SubjectNotFoundException{
        log.info(Utility.REQUEST_RECEIVED+"/subject/"+grade);
        List<String> result=getSubjectByGradeService.getSubjectByGrade(grade);
        log.info(Utility.RESPONSE_SENT);
        return ResponseEntity.ok(result);
    }
}

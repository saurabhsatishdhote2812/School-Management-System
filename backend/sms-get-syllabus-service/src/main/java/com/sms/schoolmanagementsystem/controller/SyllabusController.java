package com.sms.schoolmanagementsystem.controller;


import com.sms.schoolmanagementsystem.exception.SyllabusNotFoundException;
import com.sms.schoolmanagementsystem.model.Syllabus;
import com.sms.schoolmanagementsystem.service.SyllabusService;
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
public class SyllabusController {

    @Autowired
    SyllabusService syllabusService;

    @GetMapping("/getSyllabus/{subjectName}")
    public ResponseEntity<List<Syllabus>> getSyllabusBySubject(@PathVariable String subjectName) throws SyllabusNotFoundException {
        log.info(Utility.REQUEST_RECEIVED + "/subject/"+subjectName);
        List<Syllabus> result = syllabusService.getSyllabusBySubject(subjectName);
        log.info(Utility.RESPONSE_SENT);
        return ResponseEntity.ok(result);
    }
}

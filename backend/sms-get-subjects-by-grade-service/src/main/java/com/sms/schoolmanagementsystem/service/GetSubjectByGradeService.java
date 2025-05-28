package com.sms.schoolmanagementsystem.service;

import com.sms.schoolmanagementsystem.dao.GetSubjectByGradeRepo;
import com.sms.schoolmanagementsystem.exception.SubjectNotFoundException;
import com.sms.schoolmanagementsystem.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetSubjectByGradeService {

    @Autowired
    GetSubjectByGradeRepo getSubjectByGradeRepo;

    public List<String> getSubjectByGrade(String grade) throws SubjectNotFoundException{
        log.info(Utility.QUERY_EXECUTION_STARTED);
        List<String> subjects = getSubjectByGradeRepo.getSubjectsByGrade(grade);
        if (subjects.isEmpty()) {
            throw new SubjectNotFoundException(Utility.GRADE_NOT_FOUND + grade);
        }else{
            log.info(Utility.QUERY_EXECUTION_COMPLETED);
            return subjects;
        }
    }
}

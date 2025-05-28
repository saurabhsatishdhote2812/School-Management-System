package com.sms.schoolmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetSubjectByGradeRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getSubjectsByGrade(String grade) {
        String query="SELECT JSON_UNQUOTE(JSON_EXTRACT(syllabus, '$.subject')) AS subject FROM sub_syll WHERE JSON_UNQUOTE(JSON_EXTRACT(syllabus, '$.grade'))=?";
        return jdbcTemplate.query(query, new Object[]{grade}, (rs, rowNum) -> rs.getString("subject"));
    }

}

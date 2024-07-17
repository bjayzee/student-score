package com.studentscore.service;

import com.studentscore.data.dtos.StudentDto;
import com.studentscore.data.models.Student;
import com.studentscore.data.models.StudentReport;
import com.studentscore.data.models.StudentScore;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDto studentDto);
    StudentScore addScore(String Subject, double score, int studentId);

    List<StudentReport> generateReport();

}

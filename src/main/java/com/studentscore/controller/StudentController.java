package com.studentscore.controller;

import com.studentscore.data.dtos.AddScoreDto;
import com.studentscore.data.dtos.StudentDto;
import com.studentscore.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
//        StudentDto studentDto = new StudentDto(firstName, lastName);
        return ResponseEntity.ok(studentService.addStudent(studentDto));
    }
    @PostMapping("/score")
    public ResponseEntity<?> addScore(@RequestBody AddScoreDto addScoreDto){

        try {
            return ResponseEntity.ok(studentService.addScore(addScoreDto.subject(), addScoreDto.score(), addScoreDto.studentId()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/reports")
    public ResponseEntity<?> generateReports(){
        return ResponseEntity.ok(studentService.generateReport());
    }

    @GetMapping("/report/{studentId}")
    public ResponseEntity<?> generateReportPerStudent(@PathVariable Integer studentId){
        return ResponseEntity.ok(studentService.generateReportPerStudent(studentId));
    }
}

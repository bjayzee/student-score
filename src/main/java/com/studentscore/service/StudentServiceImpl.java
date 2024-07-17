package com.studentscore.service;

import com.studentscore.data.dtos.StudentDto;
import com.studentscore.data.models.Student;
import com.studentscore.data.models.StudentReport;
import com.studentscore.data.models.StudentScore;
import com.studentscore.data.models.Subjects;
import com.studentscore.data.repositories.StudentRepository;
import com.studentscore.data.repositories.StudentScoreRepository;
import com.studentscore.exception.StudentException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final StudentScoreRepository studentScoreRepository;
    @Override
    public Student addStudent(StudentDto studentDto) {
            return studentRepository.save(Student.builder()
                    .firstName(studentDto.firstName())
                    .lastName(studentDto.lastName()).build());

    }

    @Override
    @Transactional
    public StudentScore addScore(String subject, double score, int studentId) {

        try{
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));
            var studentScore = studentScoreRepository.save(StudentScore.builder()
                    .subjectName(Subjects.valueOf(subject.toUpperCase()))
                    .score(score)
                    .student(student)
                    .build());

            student.getSubjectScores().add(studentScore);
            studentRepository.save(student);

            return studentScore;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<StudentReport> generateReport() {

        try{
            List<Student> students = studentRepository.findAll();
            System.out.println(students);
            List<StudentReport> reports = new ArrayList<>();

            for (Student student : students) {
                StudentReport report = new StudentReport(student);
                reports.add(report);
            }

            return reports;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public StudentReport generateReportPerStudent(int studentId) {

        try{
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentException("student not found"));

            return new StudentReport(student);

        }catch (Exception e){
            throw new StudentException(e.getMessage());
        }

    }
}

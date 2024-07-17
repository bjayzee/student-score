package com.studentscore.data.repositories;

import com.studentscore.data.models.Student;
import com.studentscore.data.models.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {

}

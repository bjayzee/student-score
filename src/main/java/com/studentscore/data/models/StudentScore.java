package com.studentscore.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Subjects subjectName;
    private Double score;

    @ManyToOne
//    @JoinColumn(name = "student_id")
    @JsonBackReference
    @ToString.Exclude
    private Student student;
}

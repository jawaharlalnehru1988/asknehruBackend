package com.crud.askenehru.AskNehru.Repositories;


import com.crud.askenehru.AskNehru.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentName(String studentName);
}

package com.crud.askenehru.AskNehru.Repositories;


import com.crud.askenehru.AskNehru.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

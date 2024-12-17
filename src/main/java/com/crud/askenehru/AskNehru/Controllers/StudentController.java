package com.crud.askenehru.AskNehru.Controllers;

import com.crud.askenehru.AskNehru.Entities.Student;
import com.crud.askenehru.AskNehru.Services.ServiceImpl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

//    @PostMapping
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        Student savedStudent = studentService.saveStudentWithLaptop(student);
//        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
//    }
}

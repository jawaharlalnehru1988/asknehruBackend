package com.crud.askenehru.AskNehru.Controllers;

import com.crud.askenehru.AskNehru.Dto.StudentDTO;
import com.crud.askenehru.AskNehru.Entities.Student;
import com.crud.askenehru.AskNehru.Services.ServiceImpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentImpl studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
        StudentDTO savedStudent = studentService.saveStudentWithLaptop(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<StudentDTO> getStudentByName(@PathVariable String name) {
        StudentDTO student = studentService.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String message = studentService.deleteStudentById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO student) {
        StudentDTO updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


}

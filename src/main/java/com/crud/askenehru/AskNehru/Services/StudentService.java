package com.crud.askenehru.AskNehru.Services;

import com.crud.askenehru.AskNehru.Dto.StudentDTO;

import java.util.List;

public interface StudentService {
   StudentDTO saveStudentWithLaptop(StudentDTO studentDTO);

   List<StudentDTO> getAllStudents();

   StudentDTO getStudentById(int id);

   String deleteStudentById(int id);

   StudentDTO updateStudent(StudentDTO studentDTO);

   StudentDTO getStudentByName(String name);
}

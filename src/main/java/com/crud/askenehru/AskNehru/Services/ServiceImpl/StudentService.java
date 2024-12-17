package com.crud.askenehru.AskNehru.Services.ServiceImpl;

import com.crud.askenehru.AskNehru.Dto.LaptopDTO;
import com.crud.askenehru.AskNehru.Dto.StudentDTO;
import com.crud.askenehru.AskNehru.Entities.Laptop;
import com.crud.askenehru.AskNehru.Entities.Student;
import com.crud.askenehru.AskNehru.Repositories.LaptopRepository;
import com.crud.askenehru.AskNehru.Repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    private StudentDTO convertoDTO(Student student){
        if(student == null) return null;

        LaptopDTO laptopDTO = null;
        if(student.getLaptop() != null){
            laptopDTO = new LaptopDTO(
                    student.getLaptop().getLaptopId(),
                    student.getLaptop().getModelNumber(),
                    student.getLaptop().getBrand()
                    );
        }

        return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getAbout(), laptopDTO);
    }

    private Student convertToEntity(StudentDTO studentDTO){
        if(studentDTO == null) return null;

        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setStudentName(studentDTO.getStudentName());
        student.setAbout(studentDTO.getAbout());

        if(studentDTO.getLaptop() != null){
            Laptop laptop = new Laptop();
            laptop.setLaptopId(studentDTO.getLaptop().getLaptopId());
            laptop.setModelNumber(studentDTO.getLaptop().getModelNumber());
            laptop.setBrand(studentDTO.getLaptop().getBrand());
            laptop.setStudent(student);
            student.setLaptop(laptop);
        }
        return student;
    }

    @Transactional
    public StudentDTO saveStudentWithLaptop(StudentDTO studentDTO){
        Student student = convertToEntity(studentDTO);
        Student saveStudent = studentRepository.save(student);
        return convertoDTO(saveStudent);
    }
//    public StudentDTO getStudentById(int id){
//
//    }
}

package com.crud.askenehru.AskNehru.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int studentId;
    private String studentName;
    private String about;
    private LaptopDTO laptop;
}

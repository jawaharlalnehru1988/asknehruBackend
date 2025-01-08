package com.crud.askenehru.AskNehru.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PupilDTO {
    private Integer pupilId;
    private String pupilName;
    private String about;
    private List<CoursesDTO> courses;
}
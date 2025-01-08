package com.crud.askenehru.AskNehru.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDTO {

        private Integer courseId;
        private String courseName;
        private String courseDescription;
        private String courseDuration;
}

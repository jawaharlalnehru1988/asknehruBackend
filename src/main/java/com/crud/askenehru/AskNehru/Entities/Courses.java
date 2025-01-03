package com.crud.askenehru.AskNehru.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Courses {

    @Id
    private int courseId;
    private String courseName;
    private String courseDescription;
    private int courseDuration;

    @ManyToOne
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;

}

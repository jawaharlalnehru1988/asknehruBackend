package com.crud.askenehru.AskNehru.Entities;

import jakarta.persistence.*;
import jdk.jfr.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import java.util.EventListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private String courseDuration;

    @ManyToOne
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;

}

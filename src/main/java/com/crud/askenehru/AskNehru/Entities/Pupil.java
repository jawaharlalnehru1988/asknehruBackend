package com.crud.askenehru.AskNehru.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pupil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pupilId;
    private String pupilName;
    private String about;

    @OneToMany(mappedBy = "pupil", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Courses> courses;
}

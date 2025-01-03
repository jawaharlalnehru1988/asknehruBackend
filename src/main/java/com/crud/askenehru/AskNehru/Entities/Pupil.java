package com.crud.askenehru.AskNehru.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private int pupilId;
    private String pupilName;
    private String about;
    private Laptop laptop;

    @OneToMany(mappedBy = "pupil", cascade = CascadeType.ALL)
    private List<Courses> courses;
}

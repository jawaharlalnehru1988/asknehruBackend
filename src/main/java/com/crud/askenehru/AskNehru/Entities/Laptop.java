package com.crud.askenehru.AskNehru.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jpa_laptops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

}

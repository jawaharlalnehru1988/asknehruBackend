package com.crud.askenehru.AskNehru.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDTO {
    public LaptopDTO(int laptopId, String modelNumber, String brand) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    private int laptopId;
    private String modelNumber;
    private String brand;
    private StudentDTO student;
}

package com.crud.askenehru.AskNehru.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDTO {

    private int laptopId;
    private String modelNumber;
    private String brand;
}

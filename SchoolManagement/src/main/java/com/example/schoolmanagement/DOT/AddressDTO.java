package com.example.schoolmanagement.DOT;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "please enter area ")
    private String area;
    @NotEmpty(message = "please enter street ")
    private String street;
    @Positive
    @NotNull(message = "please enter your building Number")
    private Integer buildingNumber;
}

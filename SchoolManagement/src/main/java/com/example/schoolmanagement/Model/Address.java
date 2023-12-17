package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer Id;
    @Column(columnDefinition = "varchar(255) not null")
    private String area;
    @Column(columnDefinition = "varchar(255) not null")
    private String street;
    @Column(columnDefinition = "int not null")
   private Integer buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}

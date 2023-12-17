package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(255) not null")
    private String name;
    @ManyToOne
    @JoinColumn(name = "teach_id",referencedColumnName = "id")
    @JsonIgnore
    private Teacher teach;
    @ManyToMany
    @JsonIgnore
    private Set<Student> students;
}

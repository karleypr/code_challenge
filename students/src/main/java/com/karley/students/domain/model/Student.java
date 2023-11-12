package com.karley.students.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Modelo Student
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    /**
     * Nombre del estudiante
     */
    private String name;

    /**
     * Apellido del estudiante
     */
    private String lastName;

    /**
     * Fecha de nacimiento del estudiante
     */
    private LocalDate birthDate;

    /**
     * Lista de cursos en los que el estudiante está inscrito
     */
    private List<Course> courses;
}

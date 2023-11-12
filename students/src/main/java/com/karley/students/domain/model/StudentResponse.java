package com.karley.students.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Modelo StudentResponse
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {

    /**
     * Identificador del estudiante
     */
    private Long studentId;

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

package com.karley.students.domain.model;

import lombok.*;

import java.util.List;


/**
 * Modelo Student
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentUpdate {

    /**
     * Identificador del estudiante
     */
    private Integer studentId;

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
    private String birthDate;

    /**
     * Lista de cursos en los que el estudiante está inscrito
     */
    private List<Course> courses;
}

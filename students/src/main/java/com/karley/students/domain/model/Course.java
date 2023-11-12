package com.karley.students.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Modelo Course
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course {

    /**
     * Identificador del curso
     */
    private Integer courseId;

    /**
     * Nombre del curso
     */
    private String name;

    /**
     * Descripción del Curso
     */
    private String description;

    /**
     * Fecha de Inicio del Curso
     */
    private LocalDate startDate;

    /**
     * Fecha Fin del Curso
     */
    private LocalDate endDate;

    /**
     * Lista de estudiantes inscritos en el curso
     */
    private List<Student> students;
}

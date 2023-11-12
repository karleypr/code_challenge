package com.karley.courses.domain.model;

import lombok.*;

import java.time.LocalDate;

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

}

package com.karley.courses.domain.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Modelo CourseResponse
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseResponse {

    /**
     * Identificador del curso
     */
    private Long courseId;

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

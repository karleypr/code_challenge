package com.karley.courses.domain.model;

import lombok.*;

/**
 * Modelo CourseResponse
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseUpdate {

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
    private String startDate;

    /**
     * Fecha Fin del Curso
     */
    private String endDate;
}

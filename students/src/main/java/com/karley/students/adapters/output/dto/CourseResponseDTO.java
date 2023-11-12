package com.karley.students.adapters.output.dto;

import lombok.*;

/**
 * Clase CourseResponseDTO, objeto usado para recibir información desde
 * el micro servicio de cursos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseResponseDTO {

    /**
     * Identificador del curso
     */
    private Integer courseId;

    /**
     * Nombre del curso
     */
    private String name;

    /**
     * Descripción del curso
     */
    private String description;

    /**
     * Fecha de inicio del curso
     */
    private String startDate;

    /**
     * Fecha de finalización del curso
     */
    private String endDate;
}

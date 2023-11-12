package com.karley.students.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad Curso
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "COURSE")
public class CourseEntity {

    /**
     * Identificador del curso
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", nullable = false)
    private Integer courseId;

    /**
     * Nombre del curso
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Descripción del Curso
     */
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    /**
     * Fecha de Inicio del Curso
     */
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    /**
     * Fecha Fin del Curso
     */
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    /**
     * Relación muchos a muchos entre curso y estudiantes
     */
    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students = new ArrayList<>();
}

package com.karley.courses.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidad Estudiante
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "STUDENT")
public class StudentEntity {

    /**
     * Identificador del Estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", nullable = false)
    private Long studentId;

    /**
     * Nombre del Estudiante
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Apellido del Estudiante
     */
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;


    /**
     * Fecha de Nacimiento del Estudiante
     */
    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    /**
     * Relación muchos a muchos entre estudiantes y cursos
     */
    @JoinTable(
            name = "REL_STUDENTS_COURSES",
            joinColumns = @JoinColumn(name = "FK_STUDENT", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_COURSE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CourseEntity> courses;

}







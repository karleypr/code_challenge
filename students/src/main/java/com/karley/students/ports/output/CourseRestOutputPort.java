package com.karley.students.ports.output;

import com.karley.students.domain.model.Course;

import java.util.List;

/**
 * Interfaz puerto de salida de comunicación REST CourseRestOutputPort
 */
public interface CourseRestOutputPort {

    /**
     * Método que se comunica con el servicio /course que se encuentra en el micro servicio de cursos
     *
     * @return List<Course> - lista del modelo Course
     */
    List<Course> toListCourse();

}

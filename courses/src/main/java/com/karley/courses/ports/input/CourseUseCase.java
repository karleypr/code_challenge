package com.karley.courses.ports.input;

import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;

import java.util.List;

/**
 * Interfaz puerto de entrada CourseUseCase
 */
public interface CourseUseCase {

    /**
     * Método que crea los cursos en base de datos
     *
     * @param courseList - La lista de cursos a crear
     * @return List<CourseResponse> - lista de cursos creados
     */
    List<CourseResponse> create(List<Course> courseList);

    /**
     * Método que lee un curso en base de datos mediante su identificador
     *
     * @param courseId - Identificador del curso
     * @return - modelo CourseResponse
     */
    CourseResponse readCourse(Long courseId);

    /**
     * Método que lista todos los cursos existentes en la base de datos
     *
     * @return - List<CourseResponse> lista del modelo CourseResponse
     */
    List<CourseResponse> toListCourse();

    /**
     * Método que elimina un curso mediante su identificador
     *
     * @param courseId - Identificador del curso
     */
    void deleteCourse(Long courseId);

    /**
     * Método que actualiza los cursos existentes en base de datos
     *
     * @param courseUpdateList - La lista de cursos a actualizar
     * @return List<CourseResponse> lista del modelo CourseResponse
     */
    List<CourseResponse> updateCourse(List<CourseUpdate> courseUpdateList);
}

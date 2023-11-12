package com.karley.courses.ports.output;

import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;

import java.util.List;

/**
 * Interfaz puerto de salida CoursePersistenceOutputPort
 */
public interface CoursePersistenceOutputPort {

    /**
     * Método que crea los cursos en base de datos
     *
     * @param course - curso a crear en base de datos
     * @return - CourseResponse
     */
    CourseResponse create(Course course);

    /**
     * Método que lee un curso en base de datos mediante su identificador
     *
     * @param courseId - Identificador del curso
     * @return - CourseResponse
     */
    CourseResponse readCourse(Long courseId);

    /**
     * Método que lista todos los cursos existentes en la base de datos.
     *
     * @return List<CourseResponse> - una lista de CourseResponse
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
     * @param courseUpdate - curso que se desea actualizar
     * @return - CourseResponse
     */
    CourseResponse updateCourse(CourseUpdate courseUpdate);
}

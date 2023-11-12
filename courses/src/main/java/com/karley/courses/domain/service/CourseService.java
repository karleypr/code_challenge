package com.karley.courses.domain.service;

import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;
import com.karley.courses.ports.input.CourseUseCase;
import com.karley.courses.ports.output.CoursePersistenceOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de servicio CourseService que implementa la interfaz CourseUseCase
 */
@Service
@AllArgsConstructor
public class CourseService implements CourseUseCase {

    /**
     * Inyección del servicio CoursePersistenceOutputPort
     */
    private CoursePersistenceOutputPort coursePersistenceOutputPort;

    /**
     * Método que crea los cursos en base de datos
     *
     * @param courseList - La lista de cursos a crear
     * @return List<CourseResponse> - lista de cursos creados
     */
    @Override
    public List<CourseResponse> create(List<Course> courseList) {
        return courseList.stream().map(course -> coursePersistenceOutputPort.create(course))
                .collect(Collectors.toList());
    }

    /**
     * Método que lee un curso en base de datos mediante su identificador
     *
     * @param courseId - Identificador del curso
     * @return - modelo CourseResponse
     */
    @Override
    public CourseResponse readCourse(Long courseId) {
        return coursePersistenceOutputPort.readCourse(courseId);
    }

    /**
     * Método que lista todos los cursos existentes en la base de datos
     *
     * @return - List<CourseResponse> lista del modelo CourseResponse
     */
    @Override
    public List<CourseResponse> toListCourse() {
       return coursePersistenceOutputPort.toListCourse();
    }

    /**
     * Método que elimina un curso mediante su identificador
     *
     * @param courseId - Identificador del curso
     */
    @Override
    public void deleteCourse(Long courseId) {
        coursePersistenceOutputPort.deleteCourse(courseId);
    }

    /**
     * Método que actualiza los cursos existentes en base de datos
     *
     * @param courseUpdateList - La lista de cursos a actualizar
     * @return List<CourseResponse> lista del modelo CourseResponse
     */
    @Override
    public List<CourseResponse> updateCourse(List<CourseUpdate> courseUpdateList) {
        return courseUpdateList.stream().map(courseUpdate -> coursePersistenceOutputPort.updateCourse(courseUpdate))
                .collect(Collectors.toList());
    }

}

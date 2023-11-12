package com.karley.courses.adapters.output.persistence;

import com.karley.courses.adapters.output.persistence.mapper.CourseEntityMapper;
import com.karley.courses.adapters.output.persistence.repository.CourseRepository;
import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;
import com.karley.courses.ports.output.CoursePersistenceOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de persistencia CoursePersistenceAdapter del micro servicio de cursos,
 * que implementa la interfaz CoursePersistenceOutputPort
 */
@Service
@AllArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistenceOutputPort {

    /**
     * Inyección de la interfaz CourseRepository
     */
    private CourseRepository courseRepository;

    /**
     * Inyección del mapper CourseEntityMapper
     */
    private CourseEntityMapper courseEntityMapper;

    /**
     * Método que crea un curso en base de datos
     *
     * @param course - curso a crear en base de datos
     * @return - CourseResponse
     */
    @Override
    public CourseResponse create(Course course) {

        return courseEntityMapper.toCourseResponseFromCourseEntity(
                courseRepository.save(courseEntityMapper.toCourseEntityFromCourse(course)));

    }

    /**
     * Método que lee un curso en base de datos mediante su identificador
     *
     * @param courseId - Identificador del curso
     * @return - CourseResponse
     */
    @Override
    public CourseResponse readCourse(Long courseId) {
        return courseEntityMapper.toCourseResponseFromCourseEntity(
                courseRepository.findById(courseId).orElseThrow());
    }

    /**
     * Método que lista todos los cursos existentes en la base de datos.
     *
     * @return List<CourseResponse> - una lista de CourseResponse
     */
    @Override
    public List<CourseResponse> toListCourse() {
        return courseEntityMapper.toCourseResponseListFromCourseEntityList(courseRepository.findAllCourse());
    }

    /**
     * Método que elimina un curso mediante su identificador
     *
     * @param courseId - Identificador del curso
     */
    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    /**
     * Método que actualiza un curso existente en base de datos
     *
     * @param courseUpdate - curso que se desea actualizar
     * @return - CourseResponse
     */
    @Override
    public CourseResponse updateCourse(CourseUpdate courseUpdate) {
        return courseEntityMapper.toCourseResponseFromCourseEntity(
                courseRepository.save(courseEntityMapper.toCourseEntityFromCourseUpdate(courseUpdate)));
    }
}

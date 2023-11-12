package com.karley.students.adapters.output.rest;

import com.karley.students.adapters.output.dto.CourseResponseDTO;
import com.karley.students.adapters.output.mapper.CourseOutPutRestMapper;
import com.karley.students.domain.model.Course;
import com.karley.students.ports.output.CourseRestOutputPort;
import com.karley.students.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Clase de comunicación rest CourseOutPutRestAdapter,
 * que implementa la interfaz CoursePersistenceOutputPort,
 * y se usa para comunicar el micro servicio de estudiantes
 * con el micro servicio de cursos
 */
@Service
public class CourseOutPutRestAdapter implements CourseRestOutputPort {

    /**
     * Inyección de la clase RestTemplate
     */
    private final RestTemplate restTemplate;

    /**
     * Inyección del mapper CourseOutPutRestMapper
     */
    private final CourseOutPutRestMapper courseOutPutRestMapper;

    /**
     * Atributo que contendrá la propertie que contiene la url del servicio /course
     * que se encuentra en el micro servicio de cursos
     */
    private final String urlGetCourse;

    /**
     * Constructor CourseOutPutRestAdapter
     *
     * @param restTemplate - Objeto RestTemplate
     * @param courseOutPutRestMapper - Interfaz CourseOutPutRestMapper
     * @param urlGetCourse - url del servicio /course en el micro de cursos
     */
    @Autowired
    public CourseOutPutRestAdapter(RestTemplate restTemplate, CourseOutPutRestMapper courseOutPutRestMapper,
                                   @Value(Constants.MICRO_COURSES_GET_COURSE_URL_VALUE) String urlGetCourse) {
        this.restTemplate = restTemplate;
        this.courseOutPutRestMapper = courseOutPutRestMapper;
        this.urlGetCourse = urlGetCourse;
    }

    /**
     * Método que se comunica con el servicio /course que se encuentra en el micro servicio de cursos
     *
     * @return List<Course> - lista del modelo Course
     */
    @Override
    public List<Course> toListCourse() {
        return courseOutPutRestMapper.toCourseResponseListFromCourseResponseDtoList(
                restTemplate.exchange(urlGetCourse, HttpMethod.GET,null,
                        new ParameterizedTypeReference<List<CourseResponseDTO>>() {}).getBody());
    }






















}

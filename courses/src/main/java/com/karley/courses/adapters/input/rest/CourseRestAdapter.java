package com.karley.courses.adapters.input.rest;

import com.karley.courses.adapters.input.rest.dto.CourseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseResponseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseUpdateDTO;
import com.karley.courses.adapters.input.rest.mapper.CourseRestMapper;
import com.karley.courses.ports.input.CourseUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase RestController del micro servicio de cursos, que implementa la interfaz CourseApi
 */
@Slf4j
@RestController
@AllArgsConstructor
public class CourseRestAdapter implements CourseApi{

    /**
     * Inyección del mapper CourseRestMapper
     */
    private CourseRestMapper courseRestMapper;

    /**
     * Inyección del servicio CourseUseCase
     */
    private CourseUseCase courseUseCase;

    /**
     * Método que crea los cursos en base de datos
     *
     * @param courseDTO (required) - La lista de cursos a crear
     * @return created operation (status code 201) - List<CourseResponseDTO>
     */
    public ResponseEntity<List<CourseResponseDTO>> createCourse(List<CourseDTO> courseDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseRestMapper.toCourseResponseDtoListFromCourseResponseList(
                        courseUseCase.create(courseRestMapper.toCourseListFromCourseDtoList(courseDTO))));
    }

    /**
     * Método que lee un curso en base de datos mediante su identificador
     *
     * @param courseId (required) - Identificador del curso
     * @return successful operation (status code 200) - CourseResponseDTO
     */
    public ResponseEntity<CourseResponseDTO> readCourse(Long courseId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseRestMapper.toCourseResponseDtoFromCourseResponse(courseUseCase.readCourse(courseId)));
    }

    /**
     * Método que lista todos los cursos existentes en la base de datos
     *
     * @return successful operation (status code 200) - List<CourseResponseDTO>
     */
    public ResponseEntity<List<CourseResponseDTO>> toListCourse(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseRestMapper.toCourseResponseDtoListFromCourseResponseList(courseUseCase.toListCourse()));
    }

    /**
     * Método que elimina un curso mediante su identificador
     *
     * @param courseId (required) - Identificador del curso
     * @return successful operation (status code 200)
     */
    public ResponseEntity<Void> deleteCourse(Long courseId){
        courseUseCase.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }

    /**
     * Método que actualiza los cursos existentes en base de datos
     *
     * @param courseUpdateDTO (required) - La lista de cursos a actualizar
     * @return successful operation (status code 200) - List<CourseResponseDTO>
     */
    public ResponseEntity<List<CourseResponseDTO>> updateCourse(List<CourseUpdateDTO> courseUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseRestMapper.toCourseResponseDtoListFromCourseResponseList(
                        courseUseCase.updateCourse(
                                courseRestMapper.toCourseUpdateListFromCourseUpdateDtoList(courseUpdateDTO))));
    }
}

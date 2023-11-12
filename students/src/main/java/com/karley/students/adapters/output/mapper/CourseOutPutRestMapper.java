package com.karley.students.adapters.output.mapper;

import com.karley.students.adapters.output.dto.CourseResponseDTO;
import com.karley.students.domain.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Esta interfaz representa un mapper entre DTO y Modelo
 */
@Mapper(componentModel = "spring")
public interface CourseOutPutRestMapper {

    /**
     * Mapeo entre una List<CourseResponseDTO> a List<Course>
     *
     * @param courseResponseDtoList - lista de CourseResponseDTO
     * @return - lista de Course
     */
    List<Course> toCourseResponseListFromCourseResponseDtoList(List<CourseResponseDTO> courseResponseDtoList);
}

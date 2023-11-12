package com.karley.courses.adapters.input.rest.mapper;

import com.karley.courses.adapters.input.rest.dto.CourseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseResponseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseUpdateDTO;
import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Esta interfaz representa un mapper entre DTO y Modelo
 */
@Mapper(componentModel = "spring")
public interface CourseRestMapper {

    /**
     * Mapeo entre una List<CourseDTO> a List<Course>
     *
     * @param courseDTO - lista de CourseDTO
     * @return - lista de Course
     */
    List<Course> toCourseListFromCourseDtoList(List<CourseDTO> courseDTO);

    /**
     * Mapeo entre una List<CourseResponse> a List<CourseResponseDTO>
     *
     * @param courseResponse - lista de CourseResponse
     * @return - lista de CourseResponseDTO
     */
    List<CourseResponseDTO> toCourseResponseDtoListFromCourseResponseList(List<CourseResponse> courseResponse);

    /**
     * Mapeo entre un CourseResponse a CourseResponseDTO
     *
     * @param courseResponse - modelo CourseResponse
     * @return - DTO CourseResponseDTO
     */
    CourseResponseDTO toCourseResponseDtoFromCourseResponse(CourseResponse courseResponse);

    /**
     * Mapeo de List<CourseUpdateDTO> a List<CourseUpdate>
     *
     * @param courseUpdateDTO - lista de CourseUpdateDTO
     * @return - lista de CourseUpdate
     */
    List<CourseUpdate> toCourseUpdateListFromCourseUpdateDtoList(List<CourseUpdateDTO> courseUpdateDTO);
}

package com.karley.courses.utils;

import com.karley.courses.adapters.input.rest.dto.CourseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseResponseDTO;
import com.karley.courses.adapters.input.rest.dto.CourseUpdateDTO;
import com.karley.courses.adapters.output.persistence.entity.CourseEntity;
import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;

import java.time.LocalDate;

/**
 * Clase que contiene los mocks para los test
 */
public class MockTest {

    public CourseDTO courseDTO(String name, String description, String startDate, String endDate){
        return new CourseDTO().name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate);
    }

    public CourseResponseDTO courseResponseDTO(Integer courseId, String name, String description, String startDate,
                                               String endDate){
        return new CourseResponseDTO()
                .courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate);
    }

    public CourseUpdateDTO courseUpdateDTO(Integer courseId, String name, String description, String startDate,
                                           String endDate){
        return new CourseUpdateDTO()
                .courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate);
    }

    public Course course(String name, String description, LocalDate startDate, LocalDate endDate){
        return Course.builder()
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate).build();
    }

    public CourseResponse courseResponse(Long courseId, String name, String description, LocalDate startDate,
                                         LocalDate endDate){
        return CourseResponse.builder()
                .courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate).build();
    }

    public CourseUpdate courseUpdate(Integer courseId, String name, String description, String startDate,
                                     String endDate){
        return CourseUpdate.builder()
                .courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate).build();
    }

    public CourseEntity courseEntity(Long courseId, String name, String description, LocalDate startDate,
                                     LocalDate endDate){
        return CourseEntity.builder()
                .courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate).build();
    }


}

package com.karley.courses.adapters.output.persistence.mapper;

import com.karley.courses.adapters.output.persistence.entity.CourseEntity;
import com.karley.courses.domain.model.Course;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.domain.model.CourseUpdate;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Esta interfaz representa un mapper entre entidad y modelo
 */
@Mapper(componentModel = "spring")
public interface CourseEntityMapper {

    /**
     * Mapeo entre un Course a CourseEntity
     *
     * @param course - modelo Course
     * @return - entidad CourseEntity
     */
    CourseEntity toCourseEntityFromCourse(Course course);

    /**
     * Mapeo entre un CourseUpdate a CourseEntity
     *
     * @param courseUpdate - modelo CourseUpdate
     * @return - entidad CourseEntity
     */
    CourseEntity toCourseEntityFromCourseUpdate(CourseUpdate courseUpdate);

    /**
     * Mapeo entre un CourseEntity a CourseResponse
     *
     * @param courseEntity - entidad CourseEntity
     * @return - modelo CourseResponse
     */
    CourseResponse toCourseResponseFromCourseEntity(CourseEntity courseEntity);

    /**
     * Mapeo entre una List<CourseEntity> a List<CourseResponse>
     *
     * @param courseEntityList - Lista de CourseEntity
     * @return - Lista de CourseResponse
     */
    List<CourseResponse> toCourseResponseListFromCourseEntityList(List<CourseEntity> courseEntityList);
}

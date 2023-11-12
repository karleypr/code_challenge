package com.karley.courses.adapters.output.persistence.repository;

import com.karley.courses.adapters.output.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz CourseRepository que realiza la persistencia y que extiende de CrudRepository
 */
@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

    /**
     * Método que encuentra todos los cursos
     *
     * @return - List<CourseEntity> - lista de cursos existentes en base de datos
     */
    @Query("SELECT c " +
            "FROM CourseEntity c ")
    List<CourseEntity> findAllCourse();
}

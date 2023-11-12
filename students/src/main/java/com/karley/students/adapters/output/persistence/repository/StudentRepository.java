package com.karley.students.adapters.output.persistence.repository;

import com.karley.students.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz StudentRepository que realiza la persistencia y que extiende de CrudRepository
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    /**
     * Método que encuentra todos los estudiantes
     *
     * @return - List<StudentEntity> - lista de estudiantes existentes en base de datos
     */
    @Query("SELECT s " +
            "FROM StudentEntity s ")
    List<StudentEntity> findAllStudent();
}

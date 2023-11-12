package com.karley.students.adapters.output.persistence.mapper;

import com.karley.students.adapters.output.persistence.entity.CourseEntity;
import com.karley.students.adapters.output.persistence.entity.StudentEntity;
import com.karley.students.domain.model.Course;
import com.karley.students.domain.model.Student;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta interfaz representa un mapper entre entidad y Modelo
 */
@Mapper(componentModel = "spring")
public interface StudentEntityMapper {

    /**
     * Mapeo desde modelo Student a la entidad StudentEntity
     *
     * @param student - Student
     * @return - StudentEntity
     */
    StudentEntity toStudentEntityFromStudent(Student student);

    /**
     * Mapeo desde modelo StudentUpdate a la entidad StudentEntity
     *
     * @param studentUpdate - StudentUpdate
     * @return - StudentEntity
     */
    StudentEntity toStudentEntityFromStudentUpdate(StudentUpdate studentUpdate);

    /**
     * Mapeo desde la entidad StudentEntity al modelo StudentResponse
     * En este mapper se ignora el mapeo del atributo courses (lista de cursos en el
     * modelo StudentResponse) para evitar un stack overflow (desbordamiento de pila), y
     * posteriormente llamar al AfterMapping
     *
     * @param studentEntity - StudentEntity
     * @return - StudentResponse
     */
    @Mapping(target = "courses", ignore = true)
    StudentResponse toStudentResponseFromStudentEntity(StudentEntity studentEntity);

    /**
     * Mapper que agrega la lista de cursos de la entidad StudentEntity a la lista de cursos
     * del modelo StudentResponse, evitando un desbordamiento de pila
     *
     * @param studentEntity - Entidad estudiante (source - fuente)
     * @param studentResponse - Modelo de respuesta del estudiante (target - objetivo)
     */
    @AfterMapping
    default void afterMappingToStudentResponseFromStudentEntity(StudentEntity studentEntity,
                                                        @MappingTarget StudentResponse.StudentResponseBuilder studentResponse) {
        //Si la lista de cursos de la entidad contiene elementos, realizamos el siguiente mapeo
        if (studentEntity.getCourses() != null) {
            List<Course> list = new ArrayList<>();

            for (CourseEntity courseEntity : studentEntity.getCourses()) {
                Course course = new Course();
                course.setCourseId(courseEntity.getCourseId());
                course.setName(courseEntity.getName());
                course.setDescription(courseEntity.getDescription());
                course.setStartDate(courseEntity.getStartDate());
                course.setEndDate(courseEntity.getEndDate());

                list.add(course);
            }

            studentResponse.courses(list);
        }
        //Si no añadimos una lista vacía al atributo courses del objeto studentResponse
        else studentResponse.courses(new ArrayList<>());
    }

    /**
     * Mapeo desde una List<StudentEntity> a una List<StudentResponse>
     *
     * @param studentEntity - Lista de StudentEntity
     * @return - Lista de StudentResponse
     */
    List<StudentResponse> toStudentResponseListFromStudentEntityList(List<StudentEntity> studentEntity);
}

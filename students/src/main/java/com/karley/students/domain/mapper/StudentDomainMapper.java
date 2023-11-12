package com.karley.students.domain.mapper;

import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;
import org.mapstruct.Mapper;

/**
 * Esta interfaz representa un mapper entre Modelos
 */
@Mapper(componentModel = "spring")
public interface StudentDomainMapper {

    /**
     * Mapeo entre un StudentResponse a StudentUpdate
     *
     * @param studentResponse StudentResponse
     * @return StudentUpdate
     */
    StudentUpdate toStudentUpdateFromStudentResponse(StudentResponse studentResponse);
}

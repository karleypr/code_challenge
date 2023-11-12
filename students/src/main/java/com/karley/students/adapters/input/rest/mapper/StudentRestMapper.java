package com.karley.students.adapters.input.rest.mapper;

import com.karley.students.adapters.input.rest.dto.StudentDTO;
import com.karley.students.adapters.input.rest.dto.StudentInscriptionUnsubscribeDTO;
import com.karley.students.adapters.input.rest.dto.StudentResponseDTO;
import com.karley.students.adapters.input.rest.dto.StudentUpdateDTO;
import com.karley.students.domain.model.Student;
import com.karley.students.domain.model.StudentInscriptionUnsubscribe;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Esta interfaz representa un mapper entre DTO y Modelo
 */
@Mapper(componentModel = "spring")
public interface StudentRestMapper {

    /**
     * Mapeo entre una List<StudentDTO> a List<Student>
     *
     * @param studentDTO - lista de StudentDTO
     * @return - lista de Student
     */
    List<Student> toStudentListFromStudentDtoList(List<StudentDTO> studentDTO);

    /**
     * Mapeo entre una List<StudentResponse> a List<StudentResponseDTO>
     *
     * @param studentResponse - lista de StudentResponse
     * @return - lista de StudentResponseDTO
     */
    List<StudentResponseDTO> toStudentResponseDtoListFromStudentResponseList(List<StudentResponse> studentResponse);

    /**
     * Mapeo entre un StudentResponse a StudentResponseDTO
     *
     * @param studentResponse StudentResponse
     * @return StudentResponseDTO
     */
    @Mapping(target = "coursesList", source = "courses")
    StudentResponseDTO toStudentResponseDtoFromStudentResponse(StudentResponse studentResponse);

    /**
     * Mapeo entre una List<StudentUpdateDTO> a List<StudentUpdate>
     *
     * @param studentUpdateDTO - lista de StudentUpdateDTO
     * @return - lista de StudentUpdate
     */
    List<StudentUpdate> toStudentUpdateListFromStudentUpdateDtoList(List<StudentUpdateDTO> studentUpdateDTO);

    /**
     * Mapeo entre un StudentInscriptionUnsubscribeDTO a StudentInscriptionUnsubscribe
     *
     * @param studentInscriptionUnsubscribeDTO - modelo StudentInscriptionUnsubscribeDTO
     * @return - StudentInscriptionUnsubscribe
     */
    StudentInscriptionUnsubscribe toStudentInscriptionUnsubscribeFromStudentInscriptionUnsubscribeDTO(
            StudentInscriptionUnsubscribeDTO studentInscriptionUnsubscribeDTO);

}

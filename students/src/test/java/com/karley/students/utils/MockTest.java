package com.karley.students.utils;

import com.karley.students.adapters.input.rest.dto.*;
import com.karley.students.adapters.output.persistence.entity.CourseEntity;
import com.karley.students.adapters.output.persistence.entity.StudentEntity;
import com.karley.students.domain.model.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que contiene los mocks para los test
 */
public class MockTest {


    public StudentResponseDTO studentResponseDTO(Integer studentId, String name, String lastName, String birthDate,
                                                 List<CourseDTO> courseDtoList){
        return new StudentResponseDTO().studentId(studentId)
                .name(name)
                .lastName(lastName)
                .birthDate(birthDate)
                .coursesList(courseDtoList);
    }

    public CourseDTO courseDTO(Integer courseId, String name, String description, String startDate, String endDate){
        return new CourseDTO().courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate);
    }

    public StudentDTO studentDTO(String name, String lastName, String birthDate){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setLastName(lastName);
        studentDTO.setBirthDate(birthDate);
        return studentDTO;
    }

    public StudentUpdateDTO studentUpdateDTO(Integer studentId, String name, String lastName, String birthDate){
        return new StudentUpdateDTO().studentId(studentId)
                .name(name)
                .lastName(lastName)
                .birthDate(birthDate);
    }

    public StudentInscriptionUnsubscribeDTO studentInscriptionUnsubscribeDTO(Integer studentId,
                                                                             List<Integer> courseIdList){
        return new StudentInscriptionUnsubscribeDTO().studentId(studentId)
                .courseIdList(courseIdList);
    }

    public Course course(Integer courseId, String name, String description, LocalDate startDate, LocalDate endDate,
                         List<Student> studentsList){
        return Course.builder().courseId(courseId)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .students(studentsList).build();
    }

    public Student student(String name, String lastName, LocalDate birthDate,
                                                 List<Course> coursesList){
        return Student.builder().name(name)
                .lastName(lastName)
                .birthDate(birthDate)
                .courses(coursesList).build();
    }

    public StudentResponse studentResponse(Long studentId, String name, String lastName, LocalDate birthDate,
                                           List<Course> coursesList){
        return StudentResponse.builder().studentId(studentId)
                .name(name)
                .lastName(lastName)
                .birthDate(birthDate)
                .courses(coursesList).build();
    }

    public StudentEntity studentEntity(Long studentId, String name, String lastName, LocalDate birthDate,
                                       List<CourseEntity> coursesList){
        return StudentEntity.builder().studentId(studentId)
                .name(name)
                .lastName(lastName)
                .birthDate(birthDate)
                .courses(coursesList).build();
    }

    public StudentUpdate studentUpdate(Integer studentId, String name, String lastName, String birthDate,
                                       List<Course> courses){
        return StudentUpdate.builder().studentId(studentId)
                .name(name)
                .lastName(lastName)
                .birthDate(birthDate)
                .courses(courses).build();
    }

    public StudentInscriptionUnsubscribe studentInscriptionUnsubscribe(Integer studentId, List<Integer> courseIdList){
        return StudentInscriptionUnsubscribe.builder()
                .studentId(studentId)
                .courseIdList(courseIdList).build();
    }





}

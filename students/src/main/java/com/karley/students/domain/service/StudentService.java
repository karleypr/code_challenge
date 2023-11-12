package com.karley.students.domain.service;

import com.karley.students.domain.mapper.StudentDomainMapper;
import com.karley.students.domain.model.*;
import com.karley.students.ports.input.StudentUseCase;
import com.karley.students.ports.output.StudentPersistenceOutputPort;
import com.karley.students.ports.output.CourseRestOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de servicio StudentService que implementa la interfaz StudentUseCase
 */
@Service
@AllArgsConstructor
public class StudentService implements StudentUseCase {

    /**
     * Inyección de la interfaz StudentPersistenceOutputPort
     */
    private StudentPersistenceOutputPort studentPersistenceOutputPort;

    /**
     * Inyección de la interfaz CourseRestOutputPort
     */
    private CourseRestOutputPort courseRestOutputPort;

    /**
     * Inyección del mapper StudentDomainMapper
     */
    private StudentDomainMapper studentDomainMapper;

    /**
     * Método que crea los estudiantes
     *
     * @param studentList - Lista de estudiantes a crear
     * @return - List<StudentResponse> - Lista de estudiantes creados
     */
    @Override
    public List<StudentResponse> create(List<Student> studentList) {
        return studentList.stream().map(student -> studentPersistenceOutputPort.create(student))
                .collect(Collectors.toList());
    }

    /**
     * Método que lee un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     * @return - StudentResponse - Estudiante leído desde la base de datos
     */
    @Override
    public StudentResponse readStudent(Long studentId) {
        return studentPersistenceOutputPort.readStudent(studentId);
    }

    /**
     * Método que lee un estudiante mediante su identificador
     *
     * @return List<StudentResponse> - Lista de todos los estudiantes leídos desde la base de datos
     */
    @Override
    public List<StudentResponse> toListStudent() {
       return studentPersistenceOutputPort.toListStudent();
    }

    /**
     * Método que elimina un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     */
    @Override
    public void deleteStudent(Long studentId) {
        studentPersistenceOutputPort.deleteStudent(studentId);
    }

    /**
     * Método que actualiza los estudiantes
     *
     * @param studentUpdateList - Lista de StudentUpdate
     * @return List<StudentResponse> - Lista de estudiantes actualizados
     */
    @Override
    public List<StudentResponse> updateStudent(List<StudentUpdate> studentUpdateList) {
        return studentUpdateList.stream().map(student -> studentPersistenceOutputPort.updateStudent(student))
                .collect(Collectors.toList());
    }

    /**
     * Método que inscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribe - Modelo con el identificador del estudiante y
     *                              la lista de cursos en los que se desea inscribir
     * @return StudentResponse - Modelo con la información del estudiante inscrito en los cursos
     */
    @Override
    public StudentResponse studentInscription(StudentInscriptionUnsubscribe studentInscriptionUnsubscribe) {

        List<Course> courseList = courseRestOutputPort.toListCourse().stream()
                .filter(course -> studentInscriptionUnsubscribe.getCourseIdList().contains(course.getCourseId()))
                .collect(Collectors.toList());

        StudentUpdate studentUpdate = studentDomainMapper.toStudentUpdateFromStudentResponse(
                readStudent(studentInscriptionUnsubscribe.getStudentId().longValue()));
        studentUpdate.setCourses(courseList);

        return studentPersistenceOutputPort.updateStudent(studentUpdate);

    }

    /**
     * Método que desinscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribe - DTO con el identificador del estudiante y
     *                                      la lista de cursos en los que se desea desinscribir
     * @return StudentResponse - Modelo con la información del estudiante desinscrito en los cursos
     */
    @Override
    public StudentResponse studentUnsubscribe(StudentInscriptionUnsubscribe studentInscriptionUnsubscribe) {

        StudentResponse studentResponse = studentPersistenceOutputPort.readStudent(
                studentInscriptionUnsubscribe.getStudentId().longValue());

        List<Course> courseList = studentResponse.getCourses().stream()
                .filter(course -> !studentInscriptionUnsubscribe.getCourseIdList().contains(course.getCourseId()))
                .collect(Collectors.toList());

        studentResponse.setCourses(courseList);

        return studentPersistenceOutputPort.updateStudent(
                studentDomainMapper.toStudentUpdateFromStudentResponse(studentResponse));
    }

}

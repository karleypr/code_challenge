package com.karley.students.ports.input;

import com.karley.students.domain.model.Student;
import com.karley.students.domain.model.StudentInscriptionUnsubscribe;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;

import java.util.List;

/**
 * Interfaz puerto de entrada StudentUseCase
 */
public interface StudentUseCase {

    /**
     * Método que crea los estudiantes
     *
     * @param studentList - Lista de estudiantes a crear
     * @return - List<StudentResponse> - Lista de estudiantes creados
     */
    List<StudentResponse> create(List<Student> studentList);

    /**
     * Método que lee un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     * @return - StudentResponse - Estudiante leído desde la base de datos
     */
    StudentResponse readStudent(Long studentId);

    /**
     * Método que lee un estudiante mediante su identificador
     *
     * @return List<StudentResponse> - Lista de todos los estudiantes leídos desde la base de datos
     */
    List<StudentResponse> toListStudent();

    /**
     * Método que elimina un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     */
    void deleteStudent(Long studentId);

    /**
     * Método que actualiza los estudiantes
     *
     * @param studentUpdateList - Lista de StudentUpdate
     * @return List<StudentResponse> - Lista de estudiantes actualizados
     */
    List<StudentResponse> updateStudent(List<StudentUpdate> studentUpdateList);

    /**
     * Método que inscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribe - Modelo con el identificador del estudiante y
     *                              la lista de cursos en los que se desea inscribir
     * @return StudentResponse - Modelo con la información del estudiante inscrito en los cursos
     */
    StudentResponse studentInscription(StudentInscriptionUnsubscribe studentInscriptionUnsubscribe);

    /**
     * Método que desinscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribe - DTO con el identificador del estudiante y
     *                                      la lista de cursos en los que se desea desinscribir
     * @return StudentResponse - Modelo con la información del estudiante desinscrito en los cursos
     */
    StudentResponse studentUnsubscribe(StudentInscriptionUnsubscribe studentInscriptionUnsubscribe);
}

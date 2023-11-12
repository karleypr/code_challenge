package com.karley.students.ports.output;

import com.karley.students.domain.model.Student;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;

import java.util.List;

/**
 * Interfaz puerto de salida de persistencia StudentPersistenceOutputPort
 */
public interface StudentPersistenceOutputPort {

    /**
     * Método que crea un estudiante en base de datos
     *
     * @param student - estudiante a crear en base de datos
     * @return - StudentResponse
     */
    StudentResponse create(Student student);

    /**
     * Método que lee un estudiante en base de datos mediante su identificador
     *
     * @param studentId - Identificador del estudiante
     * @return - StudentResponse
     */
    StudentResponse readStudent(Long studentId);

    /**
     * Método que lista todos los estudiantes existentes en la base de datos.
     *
     * @return List<StudentResponse> - una lista de StudentResponse
     */
    List<StudentResponse> toListStudent();

    /**
     * Método que elimina un estudiante mediante su identificador
     *
     * @param studentId - Identificador del estudiante
     */
    void deleteStudent(Long studentId);

    /**
     * Método que actualiza un estudiante existente en base de datos
     *
     * @param studentUpdate - estudiante que se desea actualizar
     * @return - StudentResponse
     */
    StudentResponse updateStudent(StudentUpdate studentUpdate);
}

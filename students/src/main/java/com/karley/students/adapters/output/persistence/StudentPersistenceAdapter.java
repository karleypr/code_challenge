package com.karley.students.adapters.output.persistence;

import com.karley.students.adapters.output.persistence.mapper.StudentEntityMapper;
import com.karley.students.adapters.output.persistence.repository.StudentRepository;
import com.karley.students.domain.model.Student;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.model.StudentUpdate;
import com.karley.students.ports.output.StudentPersistenceOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de persistencia StudentPersistenceAdapter del micro servicio de estudiantes,
 * que implementa la interfaz StudentPersistenceOutputPort
 */
@Service
@AllArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistenceOutputPort {

    /**
     * Inyección de la interfaz StudentRepository
     */
    private StudentRepository studentRepository;

    /**
     * Inyección del mapper StudentEntityMapper
     */
    private StudentEntityMapper studentEntityMapper;

    /**
     * Método que crea un estudiante en base de datos
     *
     * @param student - estudiante a crear en base de datos
     * @return - StudentResponse
     */
    @Override
    public StudentResponse create(Student student) {
        return studentEntityMapper.toStudentResponseFromStudentEntity(
                studentRepository.save(studentEntityMapper.toStudentEntityFromStudent(student)));
    }

    /**
     * Método que lee un estudiante en base de datos mediante su identificador
     *
     * @param studentId - Identificador del estudiante
     * @return - StudentResponse
     */
    @Override
    public StudentResponse readStudent(Long studentId) {
        return studentEntityMapper.toStudentResponseFromStudentEntity(
                studentRepository.findById(studentId).orElseThrow());
    }

    /**
     * Método que lista todos los estudiantes existentes en la base de datos.
     *
     * @return List<StudentResponse> - una lista de StudentResponse
     */
    @Override
    public List<StudentResponse> toListStudent() {
        return studentEntityMapper.toStudentResponseListFromStudentEntityList(studentRepository.findAllStudent());
    }

    /**
     * Método que elimina un estudiante mediante su identificador
     *
     * @param studentId - Identificador del estudiante
     */
    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    /**
     * Método que actualiza un estudiante existente en base de datos
     *
     * @param studentUpdate - estudiante que se desea actualizar
     * @return - StudentResponse
     */
    @Override
    public StudentResponse updateStudent(StudentUpdate studentUpdate) {
        return studentEntityMapper.toStudentResponseFromStudentEntity(
                studentRepository.save(studentEntityMapper.toStudentEntityFromStudentUpdate(studentUpdate)));
    }
}

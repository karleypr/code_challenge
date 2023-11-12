package com.karley.students.adapters.input.rest;

import com.karley.students.adapters.input.rest.dto.StudentDTO;
import com.karley.students.adapters.input.rest.dto.StudentInscriptionUnsubscribeDTO;
import com.karley.students.adapters.input.rest.dto.StudentResponseDTO;
import com.karley.students.adapters.input.rest.dto.StudentUpdateDTO;
import com.karley.students.adapters.input.rest.mapper.StudentRestMapper;
import com.karley.students.ports.input.StudentUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase controller StudentRestAdapter que implementa StudentApi
 */
@Slf4j
@RestController
@AllArgsConstructor
public class StudentRestAdapter implements StudentApi{

    /**
     * Inyección del mapper StudentRestMapper
     */
    private StudentRestMapper studentRestMapper;

    /**
     * Inyección de la interfaz StudentUseCase que usamos
     * para acceder a la clase de servicio
     */
    private StudentUseCase studentUseCase;

    /**
     * Método que crea los estudiantes
     *
     * @param studentDTO List (required)
     * @return ResponseEntity<List<StudentResponseDTO>>
     */
    public ResponseEntity<List<StudentResponseDTO>> createStudent(List<StudentDTO> studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentRestMapper.toStudentResponseDtoListFromStudentResponseList(
                        studentUseCase.create(studentRestMapper.toStudentListFromStudentDtoList(studentDTO))));
    }

    /**
     * Método que lee un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     * @return - successful operation (status code 200) - StudentResponseDTO
     */
    public ResponseEntity<StudentResponseDTO> readStudent(Long studentId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponseDtoFromStudentResponse(studentUseCase.readStudent(studentId)));
    }

    /**
     * Método que lista todos los estuantes existentes en base de datos
     *
     * @return successful operation (status code 200) - List<StudentResponseDTO>
     */
   public ResponseEntity<List<StudentResponseDTO>> toListStudent(){
       return ResponseEntity.status(HttpStatus.OK)
               .body(studentRestMapper.toStudentResponseDtoListFromStudentResponseList(studentUseCase.toListStudent()));
    }

    /**
     * Método que elimina un estudiante mediante su identificador
     *
     * @param studentId - identificador del estudiante
     * @return successful operation (status code 200)
     */
    public ResponseEntity<Void> deleteStudent(Long studentId){
        studentUseCase.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

    /**
     * Método que actualiza los estudiantes indicados en el parámetro de entrada
     *
     * @param studentUpdateDTO  (required) - lista de estudiantes a actualizar
     * @return successful operation (status code 200) - List<StudentResponseDTO>
     */
    public ResponseEntity<List<StudentResponseDTO>> updateStudent(List<StudentUpdateDTO> studentUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponseDtoListFromStudentResponseList(studentUseCase.updateStudent(
                                studentRestMapper.toStudentUpdateListFromStudentUpdateDtoList(studentUpdateDTO))));
    }

    /**
     * Método que inscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribeDTO  (required) - DTO con el identificador del estudiante y
     *                                          la lista de cursos en los que se desea inscribir
     *
     * @return - successful operation (status code 200) - StudentResponseDTO
     */
    public ResponseEntity<StudentResponseDTO> studentInscription(
            StudentInscriptionUnsubscribeDTO studentInscriptionUnsubscribeDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponseDtoFromStudentResponse(studentUseCase.studentInscription(
                                studentRestMapper.toStudentInscriptionUnsubscribeFromStudentInscriptionUnsubscribeDTO(
                                        studentInscriptionUnsubscribeDTO))));
    }

    /**
     * Método que desinscribe un estuante en los cursos indicados
     *
     * @param studentInscriptionUnsubscribeDTO  (required) - DTO con el identificador del estudiante y
     *                                           la lista de cursos en los que se desea desinscribir
     * @return - successful operation (status code 200) - StudentResponseDTO
     */
    public ResponseEntity<StudentResponseDTO> studentUnsubscribe(
            StudentInscriptionUnsubscribeDTO studentInscriptionUnsubscribeDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentRestMapper.toStudentResponseDtoFromStudentResponse(studentUseCase.studentUnsubscribe(
                        studentRestMapper.toStudentInscriptionUnsubscribeFromStudentInscriptionUnsubscribeDTO(
                                studentInscriptionUnsubscribeDTO))));
    }

}

package com.karley.students.adapters.input.rest;

import com.karley.students.adapters.input.rest.dto.StudentResponseDTO;
import com.karley.students.adapters.input.rest.mapper.StudentRestMapper;
import com.karley.students.ports.input.StudentUseCase;
import com.karley.students.utils.ConstantsTest;
import com.karley.students.utils.MockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase StudentRestAdapter
 */
@SpringBootTest()
public class StudentRestAdapterTest {


    /**
     * InjectMocks de StudentRestAdapter - clase a testear
     */
    @InjectMocks
    private StudentRestAdapter studentRestAdapter;

    /**
     * Mock de StudentRestMapper para ser burlado
     */
    @Mock
    private StudentRestMapper studentRestMapper;


    /**
     * Mock de StudentUseCase para ser burlado
     */
    @Mock
    private StudentUseCase studentUseCase;

    /**
     * Inyección MockTest Clase que contiene objetos mock
     */
    private MockTest mockTest;

    /**
     * Método de inicialización de MockTest
     */
    @BeforeEach
    public void buildMock(){ mockTest = new MockTest();}

    /**
     * Test unitario que mockea la creación de los estudiantes
     */
    @Test
    public void createStudentTest(){
        when(this.studentRestMapper.toStudentResponseDtoListFromStudentResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE)))));

        ResponseEntity<List<StudentResponseDTO>> result = studentRestAdapter.createStudent(
                Collections.singletonList(mockTest.studentDTO(ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE)));

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().get(0).getName());
    }

    /**
     * Test unitario que mockea la lectura de un estudiante mediante su identificador
     */
    @Test
    public void readStudentTest(){
        when(this.studentRestMapper.toStudentResponseDtoFromStudentResponse(any()))
                .thenReturn(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE))));

        ResponseEntity<StudentResponseDTO> result = studentRestAdapter.readStudent(
                ConstantsTest.STUDENT_ID.longValue());

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().getName());
    }

    /**
     * Test unitario que mockea la lectura de todos los estudiantes
     */
    @Test
    public void toListStudentTest(){
        when(this.studentRestMapper.toStudentResponseDtoListFromStudentResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE)))));

        ResponseEntity<List<StudentResponseDTO>> result = studentRestAdapter.toListStudent();

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().get(0).getName());
    }

    /**
     * Test unitario que mockea la eliminación de un estudiante mediante su identificador
     */
    @Test
    public void deleteStudentTest(){
        ResponseEntity<Void> result = studentRestAdapter.deleteStudent(ConstantsTest.STUDENT_ID.longValue());

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    /**
     * Test unitario que mockea la actualización de los estudiantes
     */
    @Test
    public void updateStudentTest(){
        when(this.studentRestMapper.toStudentResponseDtoListFromStudentResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE)))));

        ResponseEntity<List<StudentResponseDTO>> result = studentRestAdapter.updateStudent(
                Collections.singletonList(mockTest.studentUpdateDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE)));

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().get(0).getName());
    }

    /**
     * Test unitario que mockea la inscripción de un estudiante
     */
    @Test
    public void studentInscriptionTest(){
        when(this.studentRestMapper.toStudentResponseDtoFromStudentResponse(any()))
                .thenReturn(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE))));

        ResponseEntity<StudentResponseDTO> result = studentRestAdapter.studentInscription(
                mockTest.studentInscriptionUnsubscribeDTO(ConstantsTest.STUDENT_ID,
                        Collections.singletonList(ConstantsTest.COURSE_ID)));

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().getName());
    }

    /**
     * Test unitario que mockea la baja de un estudiante en cursos
     */
    @Test
    public void studentUnsubscribeTest(){
        when(this.studentRestMapper.toStudentResponseDtoFromStudentResponse(any()))
                .thenReturn(mockTest.studentResponseDTO(ConstantsTest.STUDENT_ID,
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_ID,
                                ConstantsTest.STUDENT_NAME, ConstantsTest.COURSE_DESCRIPTION,
                                ConstantsTest.COURSE_START_DATE, ConstantsTest.COURSE_END_DATE))));

        ResponseEntity<StudentResponseDTO> result = studentRestAdapter.studentUnsubscribe(
                mockTest.studentInscriptionUnsubscribeDTO(ConstantsTest.STUDENT_ID,
                        Collections.singletonList(ConstantsTest.COURSE_ID)));

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.STUDENT_NAME, result.getBody().getName());
    }

}

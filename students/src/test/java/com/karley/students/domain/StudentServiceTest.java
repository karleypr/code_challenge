package com.karley.students.domain;

import com.karley.students.domain.mapper.StudentDomainMapper;
import com.karley.students.domain.model.Course;
import com.karley.students.domain.model.StudentResponse;
import com.karley.students.domain.service.StudentService;
import com.karley.students.ports.output.StudentPersistenceOutputPort;
import com.karley.students.ports.output.CourseRestOutputPort;
import com.karley.students.utils.ConstantsTest;
import com.karley.students.utils.MockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase StudentService
 */
@SpringBootTest()
public class StudentServiceTest {

    /**
     * InjectMocks de StudentService - clase a testear
     */
    @InjectMocks
    private StudentService studentService;

    /**
     * Mock de StudentPersistenceOutputPort
     */
    @Mock
    private StudentPersistenceOutputPort studentPersistenceOutputPort;

    /**
     * Mock de StudentRestOutputPort
     */
    @Mock
    private CourseRestOutputPort studentRestOutputPort;

    /**
     * Mock de StudentDomainMapper
     */
    @Mock
    private StudentDomainMapper studentDomainMapper;

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
     * Test unitario que mockea la creación del estudiante
     */
    @Test
    public void createStudentTest(){
        when(this.studentPersistenceOutputPort.create(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(),
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(),
                        Collections.singletonList(new Course())));

        List<StudentResponse> result = studentService.create(
                Collections.singletonList(mockTest.student(ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME,
                        LocalDate.now(), Collections.singletonList(new Course()))));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.get(0).getName());
    }

    /**
     * Test unitario que mockea la lectura de un estudiante mediante su identificador
     */
    @Test
    public void readStudentTest(){
        when(this.studentPersistenceOutputPort.readStudent(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(),
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(),
                        Collections.singletonList(new Course())));

        StudentResponse result = studentService.readStudent(ConstantsTest.STUDENT_ID.longValue());

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la lectura de todos los estudiantes
     */
    @Test
    public void toListStudentTest(){
        when(this.studentPersistenceOutputPort.toListStudent())
                .thenReturn(Collections.singletonList(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(),
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(),
                        Collections.singletonList(new Course()))));

        List<StudentResponse> result = studentService.toListStudent();

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.get(0).getName());
    }

    /**
     * Test unitario que mockea la eliminación de un estudiante mediante su identificador
     */
    @Test
    public void deleteStudentTest(){
        studentService.deleteStudent(ConstantsTest.STUDENT_ID.longValue());
    }

    /**
     * Test unitario que mockea la actualización de un estudiante
     */
    @Test
    public void updateStudentTest(){
        when(this.studentPersistenceOutputPort.updateStudent(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        List<StudentResponse> result = studentService.updateStudent(Collections.singletonList(
                mockTest.studentUpdate(ConstantsTest.STUDENT_ID, ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(new Course()))));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.get(0).getName());
    }

    /**
     * Test unitario que mockea la inscripción de un estudiante
     */
    @Test
    public void studentInscriptionTest(){
        when(this.studentDomainMapper.toStudentUpdateFromStudentResponse(any()))
                .thenReturn(mockTest.studentUpdate(ConstantsTest.STUDENT_ID, ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, ConstantsTest.STUDENT_BIRTHDATE,
                        Collections.singletonList(new Course())));

        when(this.studentPersistenceOutputPort.updateStudent(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        StudentResponse result = studentService.studentInscription(mockTest.studentInscriptionUnsubscribe(
                ConstantsTest.STUDENT_ID, Collections.singletonList(ConstantsTest.COURSE_ID)));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la desinscripción de un estudiante
     */
    @Test
    public void studentUnsubscribeTest(){
        when(this.studentPersistenceOutputPort.readStudent(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        when(this.studentPersistenceOutputPort.updateStudent(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        StudentResponse result = studentService.studentUnsubscribe(mockTest.studentInscriptionUnsubscribe(
                ConstantsTest.STUDENT_ID, Collections.singletonList(ConstantsTest.COURSE_ID)));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }
}

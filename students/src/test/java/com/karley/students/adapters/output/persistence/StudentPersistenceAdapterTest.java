package com.karley.students.adapters.output.persistence;

import com.karley.students.adapters.output.persistence.entity.StudentEntity;
import com.karley.students.adapters.output.persistence.mapper.StudentEntityMapper;
import com.karley.students.adapters.output.persistence.repository.StudentRepository;
import com.karley.students.domain.model.Course;
import com.karley.students.domain.model.StudentResponse;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase StudentPersistenceAdapter
 */
@SpringBootTest()
public class StudentPersistenceAdapterTest {

    /**
     * InjectMocks de StudentPersistenceAdapter - clase a testear
     */
    @InjectMocks
    private StudentPersistenceAdapter studentPersistenceAdapter;

    /**
     * Mock de StudentRepository
     */
    @Mock
    private StudentRepository studentRepository;

    /**
     * Mock de StudentEntityMapper
     */
    @Mock
    private StudentEntityMapper studentEntityMapper;

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
     * Test unitario que mockea la creación de un estudiante
     */
    @Test
    public void createTest(){
        when(this.studentEntityMapper.toStudentResponseFromStudentEntity(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        StudentResponse result = studentPersistenceAdapter.create(mockTest.student(ConstantsTest.STUDENT_NAME,
                ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la lectura de un estudiante
     */
    @Test
    public void readStudentTest(){
        when(this.studentEntityMapper.toStudentResponseFromStudentEntity(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        when(this.studentRepository.findById(any()))
                .thenReturn(Optional.of(new StudentEntity()));

        StudentResponse result = studentPersistenceAdapter.readStudent(ConstantsTest.STUDENT_ID.longValue());

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la lectura de todos los estudiantes
     */
    @Test
    public void toListStudentTest(){
        when(this.studentEntityMapper.toStudentResponseListFromStudentEntityList(any()))
                .thenReturn(Collections.singletonList(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(),
                        ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(),
                        Collections.singletonList(new Course()))));

        List<StudentResponse> result = studentPersistenceAdapter.toListStudent();

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.get(0).getName());
    }

    /**
     * Test unitario que mockea la eliminación de un estudiante
     */
    @Test
    public void deleteStudentTest(){
        studentPersistenceAdapter.deleteStudent(ConstantsTest.STUDENT_ID.longValue());
    }

    /**
     * Test unitario que mockea la actualización de un estudiante
     */
    @Test
    public void updateStudentTest(){
        when(this.studentEntityMapper.toStudentResponseFromStudentEntity(any()))
                .thenReturn(mockTest.studentResponse(ConstantsTest.STUDENT_ID.longValue(), ConstantsTest.STUDENT_NAME,
                        ConstantsTest.STUDENT_LAST_NAME, LocalDate.now(), Collections.singletonList(new Course())));

        StudentResponse result = studentPersistenceAdapter.updateStudent(mockTest.studentUpdate(
                ConstantsTest.STUDENT_ID, ConstantsTest.STUDENT_NAME, ConstantsTest.STUDENT_LAST_NAME,
                ConstantsTest.STUDENT_BIRTHDATE, Collections.singletonList(new Course())));

        assertNotNull(result);
        assertEquals(ConstantsTest.STUDENT_NAME, result.getName());
    }
}

package com.karley.courses.adapters.input.rest;

import com.karley.courses.adapters.input.rest.dto.CourseResponseDTO;
import com.karley.courses.adapters.input.rest.mapper.CourseRestMapper;
import com.karley.courses.ports.input.CourseUseCase;
import com.karley.courses.utils.ConstantsTest;
import com.karley.courses.utils.MockTest;
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
 * Clase que contiene los test unitarios de la clase CourseRestAdapter
 */
@SpringBootTest()
public class CourseRestAdapterTest {

    /**
     * InjectMocks de CourseRestAdapter - clase a testear
     */
    @InjectMocks
    private CourseRestAdapter courseRestAdapter;

    /**
     * Mock de CourseRestMapper para ser burlado
     */
    @Mock
    private CourseRestMapper courseRestMapper;

    /**
     * Mock de CourseUseCase para ser burlado
     */
    @Mock
    private CourseUseCase courseUseCase;

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
     * Test unitario que mockea la creación de los cursos
     */
    @Test
    public void createCourseTest(){
        when(this.courseRestMapper.toCourseResponseDtoListFromCourseResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.courseResponseDTO(ConstantsTest.COURSE_ID,
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING)));

        ResponseEntity<List<CourseResponseDTO>> result = courseRestAdapter.createCourse(
                Collections.singletonList(mockTest.courseDTO(ConstantsTest.COURSE_NAME,
                        ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING)));

        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.COURSE_NAME, result.getBody().get(0).getName());
    }

    /**
     * Test unitario que mockea la lectura de un curso mediante su identificador
     */
    @Test
    public void readCourseTest(){
        when(this.courseRestMapper.toCourseResponseDtoFromCourseResponse(any()))
                .thenReturn(mockTest.courseResponseDTO(ConstantsTest.COURSE_ID, ConstantsTest.COURSE_NAME,
                        ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING));

        ResponseEntity<CourseResponseDTO> result = courseRestAdapter.readCourse(ConstantsTest.COURSE_ID.longValue());

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.COURSE_NAME, result.getBody().getName());
    }

    /**
     * Test unitario que mockea la lectura de todos los cursos
     */
    @Test
    public void toListCourseTest(){
        when(this.courseRestMapper.toCourseResponseDtoListFromCourseResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.courseResponseDTO(ConstantsTest.COURSE_ID,
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING)));

        ResponseEntity<List<CourseResponseDTO>> result = courseRestAdapter.toListCourse();

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.COURSE_NAME, result.getBody().get(0).getName());
    }

    /**
     * Test unitario que mockea la eliminación de un curso mediante su identificador
     */
    @Test
    public void deleteCourseTest(){
        ResponseEntity<Void> result = courseRestAdapter.deleteCourse(ConstantsTest.COURSE_ID.longValue());

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    /**
     * Test unitario que mockea la actualización de los cursos
     */
    @Test
    public void updateCourseTest(){
        when(this.courseRestMapper.toCourseResponseDtoListFromCourseResponseList(any()))
                .thenReturn(Collections.singletonList(mockTest.courseResponseDTO(ConstantsTest.COURSE_ID,
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING)));

        ResponseEntity<List<CourseResponseDTO>> result = courseRestAdapter.updateCourse(
                Collections.singletonList(mockTest.courseUpdateDTO(ConstantsTest.COURSE_ID, ConstantsTest.COURSE_NAME,
                        ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                        ConstantsTest.COURSE_EMPTY_STRING)));

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.COURSE_NAME, result.getBody().get(0).getName());
    }

}

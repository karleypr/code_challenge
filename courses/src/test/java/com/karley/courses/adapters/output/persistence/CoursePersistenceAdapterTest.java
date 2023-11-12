package com.karley.courses.adapters.output.persistence;

import com.karley.courses.adapters.output.persistence.entity.CourseEntity;
import com.karley.courses.adapters.output.persistence.mapper.CourseEntityMapper;
import com.karley.courses.adapters.output.persistence.repository.CourseRepository;
import com.karley.courses.domain.model.CourseResponse;
import com.karley.courses.utils.ConstantsTest;
import com.karley.courses.utils.MockTest;
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
 * Clase que contiene los test unitarios de la clase CoursePersistenceAdapter
 */
@SpringBootTest()
public class CoursePersistenceAdapterTest {

    /**
     * InjectMocks de CoursePersistenceAdapter - clase a testear
     */
    @InjectMocks
    private CoursePersistenceAdapter coursePersistenceAdapter;

    /**
     * Mock de CourseRepository
     */
    @Mock
    private CourseRepository courseRepository;

    /**
     * Mock de CourseEntityMapper
     */
    @Mock
    private CourseEntityMapper courseEntityMapper;

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
    public void createTest(){
        when(this.courseEntityMapper.toCourseResponseFromCourseEntity(any()))
                .thenReturn(mockTest.courseResponse(ConstantsTest.COURSE_ID.longValue(),
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, LocalDate.now(), LocalDate.now()));

        CourseResponse result = coursePersistenceAdapter.create(
                mockTest.course(ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, LocalDate.now(),
                        LocalDate.now()));

        assertNotNull(result);
        assertEquals(ConstantsTest.COURSE_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la lectura de un curso mediante su identificador
     */
    @Test
    public void readCourseTest(){
        when(this.courseEntityMapper.toCourseResponseFromCourseEntity(any()))
                .thenReturn(mockTest.courseResponse(ConstantsTest.COURSE_ID.longValue(),
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, LocalDate.now(), LocalDate.now()));

        when(this.courseRepository.findById(any()))
                .thenReturn(Optional.of(new CourseEntity()));

        CourseResponse result = coursePersistenceAdapter.readCourse(ConstantsTest.COURSE_ID.longValue());

        assertNotNull(result);
        assertEquals(ConstantsTest.COURSE_NAME, result.getName());
    }

    /**
     * Test unitario que mockea la lectura de todos los cursos
     */
    @Test
    public void toListCourseTest(){
        when(this.courseEntityMapper.toCourseResponseListFromCourseEntityList(any()))
                .thenReturn(Collections.singletonList(mockTest.courseResponse(ConstantsTest.COURSE_ID.longValue(),
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, LocalDate.now(),
                        LocalDate.now())));

        List<CourseResponse> result = coursePersistenceAdapter.toListCourse();

        assertNotNull(result);
        assertEquals(ConstantsTest.COURSE_NAME, result.get(0).getName());
    }

    /**
     * Test unitario que mockea la eliminación de un curso mediante su identificador
     */
    @Test
    public void deleteCourseTest(){
        coursePersistenceAdapter.deleteCourse(ConstantsTest.COURSE_ID.longValue());
    }

    /**
     * Test unitario que mockea la actualización de los cursos
     */
    @Test
    public void updateCourseTest(){
        when(this.courseEntityMapper.toCourseResponseFromCourseEntity(any()))
                .thenReturn(mockTest.courseResponse(ConstantsTest.COURSE_ID.longValue(),
                        ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, LocalDate.now(), LocalDate.now()));

        CourseResponse result = coursePersistenceAdapter.updateCourse(mockTest.courseUpdate(ConstantsTest.COURSE_ID,
                ConstantsTest.COURSE_NAME, ConstantsTest.COURSE_DESCRIPTION, ConstantsTest.COURSE_EMPTY_STRING,
                ConstantsTest.COURSE_EMPTY_STRING));

        assertNotNull(result);
        assertEquals(ConstantsTest.COURSE_NAME, result.getName());
    }

}

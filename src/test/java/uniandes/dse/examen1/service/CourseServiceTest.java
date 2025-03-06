package uniandes.dse.examen1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uniandes.dse.examen1.entities.CourseEntity;
import uniandes.dse.examen1.exceptions.RepeatedCourseException;
import uniandes.dse.examen1.services.CourseService;

@DataJpaTest
@Transactional
@Import(CourseService.class)
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    @BeforeEach
    void setUp() {
        course = factory.manufacturePojo(CourseEntity.class);
        entityManager.persist(course);
    }
    
    @Test
    void testCreateRecordMissingCourse() {
        
    }

    @Test
    void testCreateRepeatedCourse() {
        CourseEntity coruseExistente = factory.manufacturePojo(CourseEntity.class);
        courseExistente.setId(course.getId()); 
        CourseEntity resultado = courseService.createCourse(nuevoCourse);

        assertNotNull(resultado);
        assertEquals(courseExistente.getNombre(), resultado.getNombre());
    }
}

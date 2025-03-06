package uniandes.dse.examen1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class RecordEntity {

    @PodamExclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double finalGrade;
    private String semester;

    @PodamExclude
    @ManyToOne
    private StudentEntity student;

    @PodamExclude
    @ManyToOne
    private CourseEntity course;

}

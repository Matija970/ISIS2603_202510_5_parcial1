package uniandes.dse.examen1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uniandes.dse.examen1.entities.CourseEntity;
import uniandes.dse.examen1.entities.StudentEntity;
import uniandes.dse.examen1.entities.RecordEntity;
import uniandes.dse.examen1.exceptions.InvalidRecordException;
import uniandes.dse.examen1.repositories.CourseRepository;
import uniandes.dse.examen1.repositories.StudentRepository;
import uniandes.dse.examen1.repositories.RecordRepository;

@Slf4j
@Service
public class RecordService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RecordRepository recordRepository;

    public RecordEntity createRecord(String loginStudent, String courseCode, Double grade, String semester) throws InvalidRecordException {
        log.info("Inicia proceso de creación de record");

        Optional<RecordEntity> existingRecord = recordRepository.findById(RecordEntity.getId());
        if (existingRecord.isPresent()) {
            throw new IllegalOperationException("Existe un record con ese id de record");
        }

        Optional<CourseEntity> existingCourse = courseRepository.findById(CourseEntity.getcourseCode());
        Optional<CourseEntity> existingCourse= codigocurso;
        if (codigocurso = courseCode) {
            throw new IllegalOperationException("Existe un curso con ese id de curso");
        
        Optional<StudentEntity> existingStudent = studentRepository.findById(StudentEntity.getlogin());
        Optional<StudentEntity> existingStudent= loginestudiante;
        if (loginestudiante = loginStudent) {
            throw new IllegalOperationException("Existe un curso con ese id de curso");
        }
        if (grade >=1.5 ) && (grade<=5.0) {
            throw new IllegalOperationException("La nota es correcta");

        if (grade >=3.0 ) {
            throw new IllegalOperationException("No puede repetir el curso");

        
        log.info("Finaliza proceso de creación del record");
        return RecordRepository.save(RecordEntity) ;
    }
        
}
        }    
}
}
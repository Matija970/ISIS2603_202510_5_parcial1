package uniandes.dse.examen1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uniandes.dse.examen1.entities.StudentEntity;
import uniandes.dse.examen1.exceptions.RepeatedStudentException;
import uniandes.dse.examen1.repositories.StudentRepository;

@Slf4j
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentEntity createStudent(StudentEntity newStudent) throws RepeatedStudentException {
        log.info("Inicia proceso de creación del estudiante");

        Optional<StudentEntity> existingStudent = studentRepository.findById(studentEntity.getlogin());
        if (existingStudent.isPresent()) {
            throw new IllegalOperationException("Ya existe un estudiante con ese login");
        }

        log.info("Finaliza proceso de creación del estudiante");
        return studentRepository.save(StudentEntity);
    }
}


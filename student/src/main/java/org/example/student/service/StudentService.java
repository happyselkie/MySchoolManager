package org.example.student.service;

import org.example.student.dto.StudentReceiveDto;
import org.example.student.dto.StudentResponseDto;
import org.example.student.entity.Student;
import org.example.student.exception.NotFoundException;
import org.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto create(StudentReceiveDto studentReceiveDto) {
        return studentRepository.save(studentReceiveDto.dtoToEntity()).entityToDto();
    }

    public StudentResponseDto get(Integer id){ return studentRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<StudentResponseDto> get(){
        return studentRepository.findAll().stream().map(Student::entityToDto).toList();
    }

    public StudentResponseDto update(Integer id, StudentReceiveDto studentReceiveDto){
        Student studentToUpdate = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        Student studentGet = studentReceiveDto.dtoToEntity();
        studentToUpdate.setFirstName(studentGet.getFirstName());
        studentToUpdate.setLastName(studentGet.getLastName());
        studentToUpdate.setBirthDate(studentGet.getBirthDate());
        return studentRepository.save(studentToUpdate).entityToDto();
    }

    public void delete(Integer id){ studentRepository.deleteById(id); }
}

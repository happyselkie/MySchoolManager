package org.example.teacher.service;

import org.example.teacher.dto.TeacherReceiveDto;
import org.example.teacher.dto.TeacherResponseDto;
import org.example.teacher.entity.Teacher;
import org.example.teacher.exception.NotFoundException;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponseDto create(TeacherReceiveDto teacherReceiveDto){
        return teacherRepository.save(teacherReceiveDto.dtoToEntity()).entityToDto();
    }

    public TeacherResponseDto get(Integer id){ return teacherRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<TeacherResponseDto> get(){
        return teacherRepository.findAll().stream().map(Teacher::entityToDto).toList();
    }

    public TeacherResponseDto update(Integer id, TeacherReceiveDto teacherReceiveDto){
        Teacher teacherToUpdate = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
        Teacher teacherGet = teacherReceiveDto.dtoToEntity();
        teacherToUpdate.setFirstName(teacherGet.getFirstName());
        teacherToUpdate.setLastName(teacherGet.getLastName());
        teacherToUpdate.setBirthDate(teacherGet.getBirthDate());
        return teacherRepository.save(teacherToUpdate).entityToDto();
    }

    public void delete(Integer id){ teacherRepository.deleteById(id); }
}

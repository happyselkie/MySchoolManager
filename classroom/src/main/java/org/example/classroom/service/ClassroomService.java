package org.example.classroom.service;

import org.example.classroom.dto.ClassroomReceiveDto;
import org.example.classroom.dto.ClassroomResponseDto;
import org.example.classroom.entity.Classroom;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;
import org.example.classroom.exception.NotFoundException;
import org.example.classroom.repository.ClassroomRepository;
import org.example.classroom.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private final RestTemplate restTemplate;
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository, RestTemplate restTemplate) {
        this.classroomRepository = classroomRepository;
        this.restTemplate = restTemplate;
    }

    public Classroom classroomReceiveDtoToClassroom(ClassroomReceiveDto classroom) {
        List<Student> students = new ArrayList<>();
        classroom.getStudentId().forEach(studentId -> {students.add(getStudent(studentId));});
        Teacher teacher = getTeacher(classroom.getTeacherId());
        return Classroom.builder().students(students).teacher(teacher).build();
    }

    public Student getStudent(Long id){
        RestClient<Student> studentRestClient = new RestClient<>("http://STUDENT/student/"+id, restTemplate);
        Student student = studentRestClient.get(Student.class);
        return student;
    }

    public Teacher getTeacher(Long id){
        RestClient<Teacher> teacherRestClient = new RestClient<>("http://TEACHER/teacher/"+id, restTemplate);
        Teacher teacher = teacherRestClient.get(Teacher.class);
        return teacher;
    }

    public ClassroomResponseDto create(ClassroomReceiveDto classroom){
        Classroom classroomToSave = classroomRepository.save(classroomReceiveDtoToClassroom(classroom));
        return classroomToSave.entityToDto();
    }

    public ClassroomResponseDto get(Long id){
        return classroomRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<ClassroomResponseDto> get(){
        return classroomRepository.findAll().stream().map(Classroom::entityToDto).toList();
    }

    public ClassroomResponseDto update(Long id, ClassroomReceiveDto classroom){
        Classroom classToUpdate = classroomRepository.findById(id).orElseThrow(NotFoundException::new);
        Classroom classGet = classroomReceiveDtoToClassroom(classroom);
        classToUpdate.setStudents(classGet.getStudents());
        classToUpdate.setTeacher(classGet.getTeacher());
        return classroomRepository.save(classToUpdate).entityToDto();
    }

    public void delete(Long id){ classroomRepository.deleteById(id); }
}

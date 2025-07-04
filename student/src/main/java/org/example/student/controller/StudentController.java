package org.example.student.controller;

import org.example.student.dto.StudentReceiveDto;
import org.example.student.dto.StudentResponseDto;
import org.example.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAll() { return ResponseEntity.ok(studentService.get()); }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentReceiveDto student) { return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student)); }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getById(@PathVariable Integer id) { return ResponseEntity.ok(studentService.get(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Integer id, @RequestBody StudentReceiveDto student) { return ResponseEntity.status(HttpStatus.CREATED).body(studentService.update(id, student)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok("Teacher with id " + id + " deleted.");
    }
}



package org.example.teacher.controller;

import org.example.teacher.dto.TeacherReceiveDto;
import org.example.teacher.dto.TeacherResponseDto;
import org.example.teacher.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDto>> getAll() { return ResponseEntity.ok(teacherService.get()); }

    @PostMapping
    public ResponseEntity<TeacherResponseDto> create(@RequestBody TeacherReceiveDto teacher) { return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(teacher)); }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> getById(@PathVariable Integer id) { return ResponseEntity.ok(teacherService.get(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> update(@PathVariable Integer id, @RequestBody TeacherReceiveDto teacher) { return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.update(id, teacher)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return ResponseEntity.ok("Teacher with id " + id + " deleted.");
    }
}



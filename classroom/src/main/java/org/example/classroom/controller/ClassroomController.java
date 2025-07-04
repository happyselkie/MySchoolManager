package org.example.classroom.controller;

import org.example.classroom.dto.ClassroomReceiveDto;
import org.example.classroom.dto.ClassroomResponseDto;
import org.example.classroom.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<List<ClassroomResponseDto>> getAll() { return ResponseEntity.ok(classroomService.get()); }

    @PostMapping
    public ResponseEntity<ClassroomResponseDto> create(@RequestBody ClassroomReceiveDto classroom) { return ResponseEntity.status(HttpStatus.CREATED).body(classroomService.create(classroom)); }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(classroomService.get(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomResponseDto> update(@PathVariable Long id, @RequestBody ClassroomReceiveDto classroom) { return ResponseEntity.status(HttpStatus.CREATED).body(classroomService.update(id, classroom)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        classroomService.delete(id);
        return ResponseEntity.ok("Classroom with id " + id + " deleted.");
    }
}



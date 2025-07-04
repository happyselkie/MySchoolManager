package org.example.classroom.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClassroomResponseDto {
    private List<Student> students;
    private Teacher teacher;
}

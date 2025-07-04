package org.example.classroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.dto.ClassroomResponseDto;

import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @Column(name="student")
    @CollectionTable(
            name="classroom_students",
            joinColumns=@JoinColumn(name="classroom_id")
    )
    private List<Student> students;

    @Embedded
    @AttributeOverride(name="id", column=@Column(name="teacher_id"))
    private Teacher teacher;

    public ClassroomResponseDto entityToDto() {
        return ClassroomResponseDto.builder()
                .students(getStudents())
                .teacher(getTeacher())
                .build();
    }

}

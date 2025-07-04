package org.example.classroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassroomReceiveDto {

    private List<Long> studentId;
    private Long teacherId;

}

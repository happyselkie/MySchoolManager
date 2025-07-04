package org.example.teacher.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeacherResponseDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String birthDate;
}

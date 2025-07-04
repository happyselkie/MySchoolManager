package org.example.student.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentResponseDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String birthDate;
}

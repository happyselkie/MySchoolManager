package org.example.teacher.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teacher.dto.TeacherResponseDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    public TeacherResponseDto entityToDto() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return TeacherResponseDto.builder()
                .lastName(getLastName())
                .firstName(getFirstName())
                .birthDate(getBirthDate().format(dateTimeFormatter))
                .build();
    }
}

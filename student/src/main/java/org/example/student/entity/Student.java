package org.example.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.student.dto.StudentResponseDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    public StudentResponseDto entityToDto() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return StudentResponseDto.builder()
                .id(getId())
                .lastName(getLastName())
                .firstName(getFirstName())
                .birthDate(getBirthDate().format(dateTimeFormatter))
                .build();
    }
}

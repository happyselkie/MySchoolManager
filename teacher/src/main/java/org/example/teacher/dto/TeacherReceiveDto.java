package org.example.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teacher.entity.Teacher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherReceiveDto {

    private String lastName;
    private String firstName;
    private String birthDate;

    public Teacher dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Teacher.builder()
                .lastName(getLastName())
                .firstName(getFirstName())
                .birthDate(LocalDate.parse(birthDate, dateTimeFormatter))
                .build();
    }
}

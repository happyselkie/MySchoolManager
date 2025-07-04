package org.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.student.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentReceiveDto {

    private String lastName;
    private String firstName;
    private String birthDate;

    public Student dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Student.builder()
                .lastName(getLastName())
                .firstName(getFirstName())
                .birthDate(LocalDate.parse(birthDate, dateTimeFormatter))
                .build();
    }
}

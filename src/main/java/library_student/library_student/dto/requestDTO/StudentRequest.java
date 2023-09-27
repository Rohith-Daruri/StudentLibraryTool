package library_student.library_student.dto.requestDTO;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import library_student.library_student.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    String name;
    String email;
    int age;
    Gender gender;
}

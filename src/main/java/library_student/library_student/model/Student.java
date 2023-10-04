package library_student.library_student.model;

import jakarta.persistence.*;
import library_student.library_student.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;
    String name;
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    int age;
    @OneToOne(mappedBy="student",cascade = CascadeType.ALL)
    Library library;
}

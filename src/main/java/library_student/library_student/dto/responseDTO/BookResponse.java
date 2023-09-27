package library_student.library_student.dto.responseDTO;

import library_student.library_student.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    String title;
    double price;
    String author;
    Genre genre;
}

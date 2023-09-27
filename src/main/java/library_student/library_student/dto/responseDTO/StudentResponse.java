package library_student.library_student.dto.responseDTO;

import library_student.library_student.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.usertype.StaticUserTypeSupport;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    String name;
    String message;
    LibraryResponse libraryResponse;

}

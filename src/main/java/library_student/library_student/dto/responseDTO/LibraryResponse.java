package library_student.library_student.dto.responseDTO;

import library_student.library_student.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryResponse {
    String card;
    Date issuedate;
    Status status;
}

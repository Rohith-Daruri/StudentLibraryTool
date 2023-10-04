package library_student.library_student.dto.responseDTO;

import library_student.library_student.Enum.Status;
import library_student.library_student.Enum.transaction_status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    String transaction_id;
    transaction_status status;
    String Author_name;
    String Student_name;
    String library_card;
    String book_title;
    double price;

}

package library_student.library_student.model;

import jakarta.persistence.*;
import library_student.library_student.Enum.transaction_status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Transaction_id;
    transaction_status status;
    @CreationTimestamp
    Date transaction_time;
    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    Library card;
}

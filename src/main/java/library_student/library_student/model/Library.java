package library_student.library_student.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import library_student.library_student.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String card;
    @Enumerated(EnumType.STRING)
    Status status;
    @CreationTimestamp
    Date issuedate;
    @OneToOne
    @JoinColumn
    Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transaction_list =new ArrayList<>();
}

package library_student.library_student.model;

import jakarta.persistence.*;
import library_student.library_student.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    int pages;
    @Enumerated(EnumType.STRING)
    Genre genre;
    double price;
    @ManyToOne
    @JoinColumn
    Author author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transaction_list = new ArrayList<>();
}

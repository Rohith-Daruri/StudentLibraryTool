package library_student.library_student.model;

import jakarta.persistence.*;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true,nullable = false)
    String email;
    @UpdateTimestamp
    Date lastactive;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> book = new ArrayList<>();
}

package library_student.library_student.repository;

import library_student.library_student.Enum.Genre;
import library_student.library_student.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.hibernate.metamodel.mapping.JdbcMapping.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where genre = :genre and price > :price",nativeQuery=true)
    List<Book> findByGenre(String genre,double price);
}

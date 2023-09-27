package library_student.library_student.service;

import library_student.library_student.EXCEPTION.AuthorNotFoundException;
import library_student.library_student.Enum.Genre;
import library_student.library_student.dto.responseDTO.BookResponse;
import library_student.library_student.model.Author;
import library_student.library_student.model.Book;
import library_student.library_student.repository.AuthorRepository;
import library_student.library_student.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book) {
        Optional<Author> authoroptional = authorRepository.findById(book.getAuthor().getId());
        if(authoroptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid details!!!");
        }
        Author author = authoroptional.get();
        book.setAuthor(author);
        author.getBook().add(book);
        authorRepository.save(author);
        return "Book added successfully";
    }

    public List<BookResponse> BookByPrice_Genre(String genre, double price) {
        List<Book>bookList =bookRepository.findByGenre(genre,price);
        List<BookResponse> ans = new ArrayList<>();
        for(Book book:bookList){
            BookResponse bookResponse = new BookResponse();
            bookResponse.setTitle(book.getTitle());
            bookResponse.setPrice(book.getPrice());
            bookResponse.setAuthor(book.getAuthor().getName());
            bookResponse.setGenre(book.getGenre());
            ans.add(bookResponse);
        }
        return ans;
    }
}

package library_student.library_student.service;

import library_student.library_student.model.Author;
import library_student.library_student.model.Book;
import library_student.library_student.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Authorservice {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author a = authorRepository.save(author);
        return "Author Details added successfully";
    }

    public List<String> BooksByAuthor(int id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        List<String>ans = new ArrayList<>();
        if(authorOptional.isPresent()){
            Author author =authorOptional.get();
            List<Book> result = author.getBook();
            for(Book b:result) {
                ans.add(b.getTitle());
            }
        }
        return ans;
    }
}

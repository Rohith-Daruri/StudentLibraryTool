package library_student.library_student.controller;

import library_student.library_student.EXCEPTION.AuthorNotFoundException;
import library_student.library_student.Enum.Genre;
import library_student.library_student.dto.responseDTO.BookResponse;
import library_student.library_student.model.Book;
import library_student.library_student.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book){
        try{
            String response = bookService.addBook(book);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch(AuthorNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/bygenreprice/{genre}/{price}")
    public ResponseEntity BookByPrice_Genre(@PathVariable("genre") String genre,@PathVariable("price") double price){
        List<BookResponse> ans = bookService.BookByPrice_Genre(genre,price);
        if(ans.size()>0){
            return new ResponseEntity(ans,HttpStatus.FOUND);
        }
        return new ResponseEntity("No Books found from selected list!!!",HttpStatus.NOT_FOUND);
    }
}

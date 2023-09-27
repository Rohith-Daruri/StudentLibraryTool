package library_student.library_student.controller;

import library_student.library_student.model.Author;
import library_student.library_student.service.Authorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class Authorcontroller {

    @Autowired
    Authorservice authorservice;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String s = authorservice.addAuthor(author);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }
    @GetMapping("/getbooks/{id}")
    public ResponseEntity BooksByAuthor(@PathVariable("id") int id){
        List<String> ans = authorservice.BooksByAuthor(id);
        if(ans.size()>0) {
            return new ResponseEntity(ans, HttpStatus.FOUND);
        }
        return new ResponseEntity("No detais found!!!",HttpStatus.BAD_REQUEST);

    }
}

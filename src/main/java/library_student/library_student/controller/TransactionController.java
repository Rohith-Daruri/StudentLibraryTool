package library_student.library_student.controller;

import library_student.library_student.dto.responseDTO.TransactionResponse;
import library_student.library_student.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/add_transaction/book_id/{book_id}/student_id/{student_id}")
    public ResponseEntity add_transaction(@PathVariable("book_id")int book_id,@PathVariable("student_id")int student_id){
        try{
            TransactionResponse transactionResponse = transactionService.add_transaction(book_id, student_id);
            return new ResponseEntity(transactionResponse,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
}

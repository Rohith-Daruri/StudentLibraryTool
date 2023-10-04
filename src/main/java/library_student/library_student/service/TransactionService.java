package library_student.library_student.service;

import library_student.library_student.EXCEPTION.BookNotFound;
import library_student.library_student.EXCEPTION.StudentNotFound;
import library_student.library_student.Enum.transaction_status;
import library_student.library_student.dto.responseDTO.TransactionResponse;
import library_student.library_student.model.Book;
import library_student.library_student.model.Library;
import library_student.library_student.model.Student;
import library_student.library_student.model.Transaction;
import library_student.library_student.repository.BookRepository;
import library_student.library_student.repository.Studentrepository;
import library_student.library_student.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    Studentrepository studentrepository;
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionResponse add_transaction(int bookId, int studentId) {
        Optional<Student> studentOptional  =studentrepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFound("Student not present!!!");
        }
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new BookNotFound("Book not present!!!");
        }
            Book book = bookOptional.get();
            if(book.isIssued()){
                throw new BookNotFound("Book not Available");
            }
            Student student = studentOptional.get();
            Transaction transaction = Transaction.builder()
                    .Transaction_id(String.valueOf(UUID.randomUUID()))
                    .status(transaction_status.SUCCESS)
                    .book(book)
                    .card(student.getLibrary())
                    .build();
            book.setIssued(true);
            Transaction savedtransaction =transactionRepository.save(transaction);
            book.getTransaction_list().add(savedtransaction);
            student.getLibrary().getTransaction_list().add(savedtransaction);
            bookRepository.save(book);
            studentrepository.save(student);
            TransactionResponse transactionResponse = TransactionResponse.builder()
                    .transaction_id(savedtransaction.getTransaction_id())
                    .Author_name(book.getAuthor().getName())
                    .Student_name(student.getName())
                    .library_card(student.getLibrary().getCard())
                    .status(savedtransaction.getStatus())
                    .price(book.getPrice())
                    .book_title(book.getTitle())
                    .build();
        return transactionResponse;
    }
}

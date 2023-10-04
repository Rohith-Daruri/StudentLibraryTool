package library_student.library_student.EXCEPTION;

public class BookNotFound extends RuntimeException{
    public  BookNotFound(String message){
        super(message);
    }
}

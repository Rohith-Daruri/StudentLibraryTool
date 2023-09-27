package library_student.library_student.transformer;

import library_student.library_student.Enum.Status;
import library_student.library_student.dto.responseDTO.LibraryResponse;
import library_student.library_student.dto.responseDTO.StudentResponse;
import library_student.library_student.model.Library;
import library_student.library_student.model.Student;

import java.util.UUID;

public class LibraryTransformer {
    public static Library AddLibraryCard(Student s){
        return Library.builder()
                .card(String.valueOf(UUID.randomUUID()))
                .status(Status.ACTIVE)
                .student(s)
                .build();
    }
    public static LibraryResponse ModelToResponse(Student student){
        return LibraryResponse.builder()
                .status(student.getLibrary().getStatus())
                .card(student.getLibrary().getCard())
                .issuedate(student.getLibrary().getIssuedate())
                .build();
    }
}

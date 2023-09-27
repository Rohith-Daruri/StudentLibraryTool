package library_student.library_student.transformer;

import library_student.library_student.dto.requestDTO.StudentRequest;
import library_student.library_student.dto.responseDTO.StudentResponse;
import library_student.library_student.model.Student;

public class StudentTransformer {
    public static Student RequestToModel(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .gender(studentRequest.getGender())
                .email(studentRequest.getEmail())
                .build();
    }
    public static StudentResponse ModelToResponse(Student student){
        return StudentResponse.builder()
                .name(student.getName())
                .message("Details added successfully")
                .build();
    }
}

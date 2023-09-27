package library_student.library_student.service;

import library_student.library_student.Enum.Gender;
import library_student.library_student.Enum.Status;
import library_student.library_student.dto.requestDTO.StudentRequest;
import library_student.library_student.dto.responseDTO.LibraryResponse;
import library_student.library_student.dto.responseDTO.StudentResponse;
import library_student.library_student.model.Library;
import library_student.library_student.model.Student;
import library_student.library_student.repository.Studentrepository;
import library_student.library_student.transformer.LibraryTransformer;
import library_student.library_student.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class Studentservice {
    @Autowired
    Studentrepository studentrepository;
    public StudentResponse addstudent(StudentRequest studentRequest) {
        Student s = StudentTransformer.RequestToModel(studentRequest);
        Library library = LibraryTransformer.AddLibraryCard(s);
        s.setLibrary(library);
        Student student  = studentrepository.save(s);
        StudentResponse studentResponse = StudentTransformer.ModelToResponse(student);
        LibraryResponse libraryResponse = LibraryTransformer.ModelToResponse(student);
        studentResponse.setLibraryResponse(libraryResponse);
        return studentResponse;

    }

    public Student getstudent(int regNo) {
        Optional<Student> studentOptional = studentrepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public List<String> getallStudents() {
        List<Student> s = studentrepository.findAll();
        List<String> ans = new ArrayList<>();
        for(Student student:s){
            ans.add(student.getName());
        }
        return ans;
    }

    public List<String> getbygender(Gender gender) {
        List<Student> student = studentrepository.findByGender(gender);
        List<String> ans = new ArrayList<>();
        for(Student s:student){
                ans.add(s.getName());
        }
        return ans;
    }


}

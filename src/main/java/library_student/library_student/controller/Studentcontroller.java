package library_student.library_student.controller;

import library_student.library_student.Enum.Gender;
import library_student.library_student.dto.requestDTO.StudentRequest;
import library_student.library_student.dto.responseDTO.StudentResponse;
import library_student.library_student.model.Student;
import library_student.library_student.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class Studentcontroller {
    @Autowired
    Studentservice studentservice;
    @PostMapping("/add")
    public ResponseEntity addstudent(@RequestBody StudentRequest studentRequest){
        StudentResponse s =  studentservice.addstudent(studentRequest);
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getstudent(@PathVariable("id") int regNo){
         return new ResponseEntity<>(studentservice.getstudent(regNo),HttpStatus.FOUND);
    }
    @GetMapping("/getall")
    public ResponseEntity getallStudents(){
        return new ResponseEntity(studentservice.getallStudents(),HttpStatus.FOUND);
    }
    @GetMapping("/bygender/{gender}")
    public ResponseEntity getbygender(@PathVariable("gender") Gender gender){
        return new ResponseEntity(studentservice.getbygender(gender),HttpStatus.FOUND);
    }

}

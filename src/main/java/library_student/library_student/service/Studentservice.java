package library_student.library_student.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import library_student.library_student.EXCEPTION.MailNotFound;
import library_student.library_student.EXCEPTION.StudentNotFound;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class Studentservice {
    @Autowired
    Studentrepository studentrepository;
    @Autowired
    JavaMailSender javaMailSender;
    public StudentResponse addstudent(StudentRequest studentRequest) throws MessagingException {
        Student s = StudentTransformer.RequestToModel(studentRequest);
        Library library = LibraryTransformer.AddLibraryCard(s);
        s.setLibrary(library);
        Student student  = studentrepository.save(s);
        String text = "Congratulations!!!\n"+"\n"+"Hi "+student.getName()+",\n"+"Your Registration is successful.\n"+"\n"+"Please find the Registration details below.\n"+"\n"+"Card:- "+student.getLibrary().getCard()+"\n"+"Card status:- "+student.getLibrary().getStatus()+"\n"+"\n"+"\n"+"Regards,\n"+"\n"+"RD INSTITUTIONS,\n"+"Tirupati, Andhra Pradesh.\n"+"Phone:- 8296431478.\n"+"\n"+"www.rdinstitutions.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("acciospringtest@gmail.com");
        mimeMessageHelper.setTo(student.getEmail());
        mimeMessageHelper.setSubject("Congratulations!!!! Registration Done");
        mimeMessageHelper.setText(text);
        String attachment = "C:\\Users\\RD\\Downloads\\BYTES.jpg";
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);
        StudentResponse studentResponse = StudentTransformer.ModelToResponse(student);
        LibraryResponse libraryResponse = LibraryTransformer.ModelToResponse(student);
        studentResponse.setLibraryResponse(libraryResponse);
        return studentResponse;

    }

    public StudentResponse getstudent(int regNo) {
        Optional<Student> studentOptional = studentrepository.findById(regNo);
        if(studentOptional.isEmpty()){
            throw new StudentNotFound("Student not found!!!");
        }
            Student s  =studentOptional.get();
            LibraryResponse libraryResponse = LibraryTransformer.ModelToResponse(s);
            StudentResponse studentResponse = StudentTransformer.ModelToResponse(s);
            studentResponse.setLibraryResponse(libraryResponse);
            return studentResponse;
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

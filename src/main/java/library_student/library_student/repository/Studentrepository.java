package library_student.library_student.repository;

import library_student.library_student.Enum.Gender;
import library_student.library_student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepository extends JpaRepository<Student,Integer> {
    List<Student> findByGender(Gender gender);

}

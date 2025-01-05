package bd.edu.seu.finalproject.servise;

import bd.edu.seu.finalproject.model.Student;
import bd.edu.seu.finalproject.repository.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private Student_Repository studentRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Student registerStudent(String email, String password) {
        if (studentRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }
        Student student = new Student();
        student.setEmail(email);
        student.setPassword(passwordEncoder.encode(password));
        return studentRepository.save(student);
    }

    public boolean authenticateStudent(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            return passwordEncoder.matches(password, studentOpt.get().getPassword());
        }
        return false;
    }
}

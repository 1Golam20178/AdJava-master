package bd.edu.seu.finalproject.controller;


import bd.edu.seu.finalproject.model.Student;
import bd.edu.seu.finalproject.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = studentService.registerStudent(student.getEmail(), student.getPassword());
            return ResponseEntity.ok("Student registered successfully: " + registeredStudent.getEmail());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateStudent(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = studentService.authenticateStudent(email, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful for: " + email);
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}

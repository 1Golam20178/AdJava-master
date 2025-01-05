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

    /**
     * Endpoint to register a new student.
     *
     * @param student The student object with email and password.
     * @return A success message if the student is registered, or an error message if email is already in use.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = studentService.registerStudent(student.getEmail(), student.getPassword());
            return ResponseEntity.ok("Student registered successfully: " + registeredStudent.getEmail());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint to authenticate a student.
     *
     * @param email The email of the student.
     * @param password The password of the student.
     * @return A success or failure message based on authentication.
     */
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

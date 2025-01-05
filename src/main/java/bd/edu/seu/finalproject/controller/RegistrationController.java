package bd.edu.seu.finalproject.controller;

import bd.edu.seu.finalproject.model.Student;
import bd.edu.seu.finalproject.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

    @Autowired

    private StudentService studentService;

    @PostMapping("/registration")
    public ResponseEntity<String> registerStudent(@RequestParam String email, @RequestParam String password) {
        try {
            studentService.registerStudent(email, password);
            return ResponseEntity.ok("Student registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = studentService.authenticateStudent(email, password);
        if (authenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }
}

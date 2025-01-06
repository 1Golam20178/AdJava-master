package bd.edu.seu.finalproject.controller;

import bd.edu.seu.finalproject.model.Student;
import bd.edu.seu.finalproject.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String showLoginPage() {
        System.out.println("Navigating to the registration page.");
        return "registration"; // The registration.html file in src/main/resources/templates
    }
}

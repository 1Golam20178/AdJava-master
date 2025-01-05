package bd.edu.seu.finalproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Handle Registration Form Submission
    @PostMapping("/registration")
    public String handleRegistration(String username, String password, String email, Model model) {

        System.out.println("hello");

        if ("admin@cms.com".equals(email) && "123".equals(password)) {
            model.addAttribute("message", "Welcome, " + email + "!");
            return "adminDashboard"; // Redirect to a dashboard page
        }
        // Perform validation and save user data
        // For demonstration, we just add a message
        model.addAttribute("successMessage", "User registered successfully!");
        return "userDashboard"; // Redirect to login page after registration
    }

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // The login.html file in src/main/resources/templates
    }

    // Handle login form submission
    @PostMapping("/login")
    public String handleLogin(String email, String password,
            Model model) {
        System.out.println("Hello1");
        System.out.println(password);
        // Example: Simple hardcoded authentication logic
        if ("admin@cms.com".equals(email) && "123".equals(password)) {
            model.addAttribute("message", "Welcome, " + email + "!");
            return "userDashboard"; // Redirect to a dashboard page
        }

        // If login fails, display an error message
        model.addAttribute("error", "Invalid email or password!");
        return "login"; // Reload the login page with an error message
    }

    /*@GetMapping("/registration")
    public String aboutPage(Model model) {
        return "registration"; // This corresponds to a Thymeleaf template named "about.html"
    }*/
}

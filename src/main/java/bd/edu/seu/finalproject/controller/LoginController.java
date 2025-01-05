package bd.edu.seu.finalproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // The login.html file in src/main/resources/templates
    }

    // Handle login form submission
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        // Example: Simple hardcoded authentication logic
        if ("admin@cms.com".equals(email) && "password123".equals(password)) {
            model.addAttribute("message", "Welcome, " + email + "!");
            return "userDashboard"; // Redirect to a dashboard page
        }

        // If login fails, display an error message
        model.addAttribute("error", "Invalid email or password!");
        return "login"; // Reload the login page with an error message
    }
}

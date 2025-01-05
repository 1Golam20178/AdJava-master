package bd.edu.seu.finalproject.controller;

import bd.edu.seu.finalproject.servise.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

    private final AdminService adminService;

    public AdminDashboardController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        model.addAttribute("totalClasses", adminService.getTotalClasses());
        model.addAttribute("teacherInfo", adminService.getTeacherInfo());
        model.addAttribute("salary", adminService.getSalary());
        return "adminDashboard"; // Refers to the `adminDashboard.html` template
    }
}

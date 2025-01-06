package bd.edu.seu.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAdminCard {

    @GetMapping("/admit-card")
    public String admitCard() {
        System.out.println("Admit card");
        return "userAdmit";
    }

    @GetMapping("/code-of-conduct")
    public String codeOfConductPage() {
        System.out.println("Code of Conduct");
        return "userCodeOfConduct";
    }

    @GetMapping("/notice")
    public String notice() {
        System.out.println("Notice ");
        return "userNotice";
    }
    @GetMapping("/grade")
    public String grade() {
        System.out.println("Grade");
        return "usergrade";
    }
    @GetMapping("/mail")
    public String mail() {
        System.out.println("Email");
        return "userMail";
    }

    @GetMapping("/feedback")
    public String feedback() {
        System.out.println("Teacher Feedback");
        return "userteacherfeedbask";
    }

    @GetMapping("/location")
    public String location() {
        System.out.println("Location");
        return "userMap";
    }


    @GetMapping("/schedule")
    public String schedulen() {
        System.out.println("Schedule");
        return "userschedule";
    }
    @GetMapping("/studentlist")
    public String studentlist() {
        System.out.println("Studentlist");
        return "adminStudentList";
    }





}

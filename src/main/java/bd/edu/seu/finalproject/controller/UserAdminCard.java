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
}

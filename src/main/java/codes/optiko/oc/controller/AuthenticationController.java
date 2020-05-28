package codes.optiko.oc.controller;

import codes.optiko.oc.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
   private final PostRepository postRepo;

    public AuthenticationController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String showProfile(Model model){
        model.addAttribute("post", postRepo.findAll());
        return "users/profile";
    }
}

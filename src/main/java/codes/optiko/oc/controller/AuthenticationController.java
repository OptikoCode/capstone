package codes.optiko.oc.controller;

import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
//    private final UserRepository users;
//   private final PostRepository postRepo;
//
//    public AuthenticationController(UserRepository users, PostRepository postRepo) {
//        this.users = users;
//        this.postRepo = postRepo;
//    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String showProfile(){
        return "users/profile";
    }
}
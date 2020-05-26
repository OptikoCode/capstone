package codes.optiko.oc.controller;

import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    //********* DEPENDENCY INJECTION ***********
    private PostRepository postRepo;
    private UserRepository userRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }
    //***************************************


    //********* SHOW ALL POSTS ***********
    @GetMapping("/posts")
    public String showPosts(Model model){
        //da wae of jpa:
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }
    //***********************************
}

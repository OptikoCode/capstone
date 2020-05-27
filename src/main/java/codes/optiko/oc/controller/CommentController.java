package codes.optiko.oc.controller;

import codes.optiko.oc.repositories.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {

    //********* DEPENDENCY INJECTION ***********
    private CommentRepository commentRepo;

    public CommentController(CommentRepository commentRepo){
        this.commentRepo = commentRepo;
    }
    //***********************************

    //********* SHOW ALL POSTS ***********
//    @GetMapping("/comments")
}

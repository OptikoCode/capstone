package codes.optiko.oc.controller;

import codes.optiko.oc.model.Post;
import codes.optiko.oc.model.Response;
import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.ResponseRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;

@Controller
public class ResponseController {
    //********* DEPENDENCY INJECTION ***********
    private UserRepository userRepo;
    private PostRepository postRepo;
    private ResponseRepository responseRepo;

    public ResponseController(UserRepository userRepo, PostRepository postRepo, ResponseRepository responseRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.responseRepo = responseRepo;
    }

//    @GetMapping("/posts/{id}")
//    public String showResponses(@PathVariable long id, Model model) {
//        model.addAttribute("responses", responseRepo.findByPostId(id));
//
//        return "/posts/show";
//    }

//    @GetMapping("/posts/{id}/create-response")
//    public String createResponse(@PathVariable long id, Model model) {
//        model.addAttribute("responses", new Response());
//
//        return "/posts/create-response";
//    }

    @PostMapping("/posts/{id}/create-response")
    public String createResponse(@PathVariable long id, @ModelAttribute Response response) {
        Post post = postRepo.getOne(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        response.setPost(post);
        response.setUser(user);
        response.setCreateDate(new Timestamp(System.currentTimeMillis()));

        responseRepo.save(response);

        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{post_id}/edit-response/{response_id}")
    public String editResponse(@PathVariable long post_id, @PathVariable long response_id, Model model) {
        model.addAttribute("responses", responseRepo.getOne(response_id));

        return "/posts/edit-response";
    }

    @PostMapping("/posts/{post_id}/edit-response/{response_id}")
    public String editResponse(@PathVariable long post_id, @PathVariable long response_id, @ModelAttribute Response response) {
        response.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        responseRepo.save(response);

        return "redirect:/posts/" + post_id;
    }

    @PostMapping("/posts/{post_id}/delete-response/{response_id}")
    public String deleteResponse(@PathVariable long post_id, @PathVariable long response_id) {
        responseRepo.deleteById(response_id);

        return "redirect:/posts/" + post_id;
    }
}

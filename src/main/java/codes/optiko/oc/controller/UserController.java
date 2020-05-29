package codes.optiko.oc.controller;

import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;
    private PostRepository posts;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder, PostRepository posts){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.posts = posts;
    }
//**************** Registration Functionality ***********************
    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }
//*** After a user signs up they will be redirected to the login page ***
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "users/login";
    }

//    @GetMapping("/logout")
//    public String logoutUser(){
//        return "redirect:/login?logout";
//    }

    @PostMapping("/login")
    public String showProfile(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        user.getId();
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfileIndexPage(Model model) {
        model.addAttribute("post", posts.findAll());
        return "users/profile";
    }

//****************** Edit Post functionality *************
    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable String id, Model model){
        long parseId = Long.parseLong(id);
        User user = users.findById(parseId);
        model.addAttribute("user", user);
        return "users/edit";
    }
//************** This will update the user info in the database ********************
    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable long id, @ModelAttribute User user){
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        users.save(user);
        return "redirect:/user/edit/" + user.getId();
    }

//************** This is the Delete Functionality *******************
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        users.deleteById(id);
        return "redirect:/posts";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/image")
    public String uploadFunctionality(){
        return"posts/image";
    }
//    @GetMapping("/user/delete/{id}")
//    public String logout(@PathVariable long id) {
//        users.logout()
//    }

}

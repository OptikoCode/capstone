package codes.optiko.oc.controller;

import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
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
//************  This is the user login functionality*********
//    @GetMapping("/login")
//    public String userLogin(){
//        return "users/login";
//    }


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

//************** This is the Delete Functionality [I Have not tested it yet] *******************
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        users.deleteById(id);
        return "redirect:/posts";
    }

//    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.DELETE)
//    public void deleteUser(@PathVariable long id) {
//        users.deleteById(id);
//    }

}

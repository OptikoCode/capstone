//package codes.optiko.oc.controller;
//
//import codes.optiko.oc.model.User;
//import codes.optiko.oc.repositories.PostRepository;
//import codes.optiko.oc.repositories.UserRepository;
//import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.security.auth.login.LoginException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class AuthenticationController {
////   private final UserRepository users;
////   private final PostRepository postRepo;
//////
////    public AuthenticationController(UserRepository users, PostRepository postRepo) {
////        this.users = users;
////        this.postRepo = postRepo;
////    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "users/login";
//    }
//////
//}

//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String loginPage () throws LoginException {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null){
////            new SecurityContextLogoutHandler().loginPage(request, response, auth);
//            new SecurityContextLoginModule().login();
//        }
//        return "redirect:/profile";
//    }
//}
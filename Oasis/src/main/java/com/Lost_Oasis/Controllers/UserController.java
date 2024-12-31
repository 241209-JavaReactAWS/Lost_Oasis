package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8080",allowCredentials="true")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerHandler(@RequestBody User user){
        User possibleUser = userService.createNewUser(user);
        System.out.println("trying to create");
        if(possibleUser != null){
            return new ResponseEntity<>(possibleUser, HttpStatus.CREATED);
        }
        System.out.println("Failed to create");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginHandler(@RequestBody User user, HttpSession session){
        User possibleUser = userService.loginUser(user);

        if(possibleUser != null){
            session.setAttribute("email", possibleUser.getEmail());
            session.setAttribute("userId", possibleUser.getUserId());
            session.setAttribute("role", possibleUser.getRole());

            return new ResponseEntity<>(possibleUser, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutHandler(HttpSession session){
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

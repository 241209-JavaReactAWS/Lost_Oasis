package com.Lost_Oasis.Controllers;

import com.Lost_Oasis.Models.User;
import com.Lost_Oasis.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        if(possibleUser != null){
            return new ResponseEntity<>(possibleUser, HttpStatus.CREATED);
        }
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

    // User Auth
    @GetMapping("/user")
    public ResponseEntity<User> getUserHandler(HttpSession session){
        if(session.isNew() || session.getAttribute("email") == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        User account = userService.getUserByEmail((String) session.getAttribute("email"));

        return ResponseEntity.ok(account);
    }

    @PatchMapping("/user")
    public ResponseEntity<User> patchUserHandler(HttpSession session, @RequestBody User user){
        if(session.isNew() || session.getAttribute("email") == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        int userId = (int)session.getAttribute("userId");

        userService.updateUser(userId, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

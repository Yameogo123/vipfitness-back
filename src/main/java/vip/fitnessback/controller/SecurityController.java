package vip.fitnessback.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import vip.fitnessback.model.User;
import vip.fitnessback.service.Handle;
import vip.fitnessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class SecurityController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/new")
    public User addUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @GetMapping("/all")
    public List<User> allUser(){
        return userService.allUser();
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable long id, @RequestPart MultipartFile file) throws IOException {
        User user= userService.getById(id);
        return userService.updateUser(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        User u= userService.getUserByUsername(user.getUsername());
        if(passwordEncoder.matches(user.getPassword(), u.getPassword())){
            return u;
        }
        return null;
    }




}



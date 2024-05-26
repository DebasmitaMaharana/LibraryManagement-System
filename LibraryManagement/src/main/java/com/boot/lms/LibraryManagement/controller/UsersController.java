package com.boot.lms.LibraryManagement.controller;

import com.boot.lms.LibraryManagement.objects.UserRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public interface UsersController {
    @GetMapping("/")
    List<UserRequest> getUsersData();

    @GetMapping("/{usersId}")
    public UserRequest getUsersById(@PathVariable int usersId);

    @PostMapping("/adduser")
    public UserRequest addUsers(@RequestBody UserRequest userRequest);

    @DeleteMapping("/{usersId}")
    public String removeUsers(@PathVariable int usersId);

    @PutMapping("/update")
    public UserRequest updateUsers(@RequestBody UserRequest userRequest);

    @PostMapping("/login")
    public String UserLogIn(@ModelAttribute UserRequest userRequest, Model model);

}

package com.boot.lms.LibraryManagement.controllerImp;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.controller.UsersController;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import com.boot.lms.LibraryManagement.serviceImp.UsersService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class UserController_imp implements UsersController {
    @Autowired
    private UsersService_Imp usersService;

    @Override
    public List<UserRequest> getUsersData() {
        return usersService.getUsersData();
    }

    @Override
    public UserRequest getUsersById(@PathVariable int usersId) {
        UserRequest userRequest = usersService.findById(usersId);
        if (userRequest == null)
            throw new UserNotFoundException("User id not found-" + usersId);
        return userRequest;
    }

    @Override
    public UserRequest addUsers(@RequestBody UserRequest userRequest) {
        return usersService.save(userRequest);
    }

    @Override
    public String removeUsers(@PathVariable int usersId) {
        UserRequest userRequest = usersService.findById(usersId);
        if (userRequest == null)
            throw new RuntimeException("Users id not found" + usersId);
        usersService.deleteById(usersId);
        return "deleted employee id- " + usersId;
    }

    @Override
    public UserRequest updateUsers(@RequestBody UserRequest userRequest) {
        return usersService.update(userRequest);
    }

    @Override
    public String UserLogIn(@ModelAttribute UserRequest userRequest, Model model) {
        UserRequest existingUser = usersService.findById(userRequest.getUserId());
        if (existingUser != null && existingUser.getPassword().equals(userRequest.getPassword())) {
            model.addAttribute("msg", "LogIn Successful !!!");
            return "LogInResult";
        } else {
            model.addAttribute("msg", "Invalid username or password !!!");
            return "UserLogIn";
        }
    }


}
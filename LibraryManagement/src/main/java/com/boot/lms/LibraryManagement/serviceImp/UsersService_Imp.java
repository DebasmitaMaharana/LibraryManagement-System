package com.boot.lms.LibraryManagement.serviceImp;

import com.boot.lms.LibraryManagement.Service.UserService;
import com.boot.lms.LibraryManagement.Util.UsersUtil;
import com.boot.lms.LibraryManagement.entity.Users;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import com.boot.lms.LibraryManagement.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService_Imp implements UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserRequest> getUsersData() {
        List<UserRequest> allUserRequest = new ArrayList<>();

        List<Users> users = userRepo.findAll();
        for (Users eachUsers : users) {
            UserRequest userRequest = UsersUtil.convertUserToUserRequest(eachUsers);
            allUserRequest.add(userRequest);
        }
        return allUserRequest;

    }

    @Override
    public UserRequest save(UserRequest userRequest) {
        Optional<Users> users = userRepo.findByEmailId(userRequest.getEmailId());
        Users dbUsers;
        UserRequest userReq = null;
        if (users.isEmpty()) {
            dbUsers = userRepo.save(UsersUtil.convertUserRequestToUser(userRequest));
            userReq = UsersUtil.convertUserToUserRequest(dbUsers);
        }
        return userReq;
    }


    @Override
    public UserRequest findById(int id) {
        Optional<Users> users = userRepo.findById(id);
        return UsersUtil.convertUserToUserRequest(users.orElse(null));

    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);

    }

    @Override
    public UserRequest update(UserRequest userRequest) {
        Optional<Users> users = userRepo.findByEmailId(userRequest.getEmailId());
        Users user = null;
        if (users.isPresent()) {
            user = users.get();
            user.setUserName(userRequest.getUserName());
            user.setLibrarian(userRequest.getLibrarian());
            user.setEmailId(userRequest.getEmailId());
            user.setPassword(userRequest.getPassword());
            userRepo.save(user);
        }
        return user != null ? UsersUtil.convertUserToUserRequest(user) : new UserRequest();
    }
}
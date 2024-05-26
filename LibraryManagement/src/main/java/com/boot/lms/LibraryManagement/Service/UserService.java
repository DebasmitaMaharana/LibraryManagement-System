package com.boot.lms.LibraryManagement.Service;


import com.boot.lms.LibraryManagement.objects.UserRequest;

import java.util.List;

public interface UserService {
    List<UserRequest> getUsersData();

    UserRequest save(UserRequest userRequest);

    UserRequest findById(int id);

    void deleteById(int id);

    //Optional<Users> findByNameAndPass(String name, String pass);
    UserRequest update(UserRequest userRequest);
}

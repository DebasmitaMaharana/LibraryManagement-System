package com.boot.lms.LibraryManagement.Util;

import com.boot.lms.LibraryManagement.entity.Users;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import lombok.experimental.UtilityClass;


@UtilityClass
public class UsersUtil {
    public static Users convertUserRequestToUser(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        return Users.builder()
                .userName(userRequest.getUserName())
                .password(userRequest.getPassword())
                .emailId(userRequest.getEmailId())
                .librarian(userRequest.getLibrarian())
                .build();
    }

    public static UserRequest convertUserToUserRequest(Users users) {
        if (users == null)
            return null;

        return UserRequest.builder()
                .userId(users.getUserId())
                .userName(users.getUserName())
                .password(users.getPassword())
                .emailId(users.getEmailId())
                .librarian(users.getLibrarian())
                .build();


    }

}

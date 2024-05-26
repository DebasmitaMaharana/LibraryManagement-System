package com.boot.lms.LibraryManagement.objects;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {
    private int userId;
    private String userName;
    private String password;
    private String emailId;
    private Boolean librarian;
}
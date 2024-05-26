package com.boot.lms.LibraryManagement.objects;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class BooksRegistration_Request {
    private Integer registrationId;
    private String bookId;
    private String userId;
    private LocalDateTime registrationDate;

}

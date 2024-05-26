package com.boot.lms.LibraryManagement.objects;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BooksTransaction_Request {
    private int transactionId;
    private int registrationId;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;
    private double fine;
}

package com.boot.lms.LibraryManagement.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BooksInventoryErrorresponse
{
    private int status;
    private String message;
    private long timeStamp;
}

package com.boot.lms.LibraryManagement.serviceImp;

import com.boot.lms.LibraryManagement.Service.BooksInventoryService;
import com.boot.lms.LibraryManagement.Service.BooksRegistrationService;
import com.boot.lms.LibraryManagement.Service.BooksTransactionService;
import com.boot.lms.LibraryManagement.Util.BooksInventoryUtil;
import com.boot.lms.LibraryManagement.Util.BooksRegistrationUtil;
import com.boot.lms.LibraryManagement.Util.BooksTransactionUtil;
import com.boot.lms.LibraryManagement.entity.BooksInventory;
import com.boot.lms.LibraryManagement.entity.BooksRegistration;
import com.boot.lms.LibraryManagement.entity.Users;
import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import com.boot.lms.LibraryManagement.repository.BooksInventoryRepo;
import com.boot.lms.LibraryManagement.repository.BooksRegistrationRepository;
import com.boot.lms.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksRegistrationService_Imp implements BooksRegistrationService {
    @Autowired
    private BooksRegistrationRepository booksRegistrationRepository;
    @Autowired
    private BooksInventoryRepo booksInventoryRepo;
    @Autowired
    private BooksInventoryService booksInventoryService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BooksTransactionService booksTransactionService;

    @Override
    public List<BooksRegistration_Request> getAllRegisteredBook() {
        List<BooksRegistration_Request> booksRegistration_Request = new ArrayList<>();
        List<BooksRegistration> booksRegistration = booksRegistrationRepository.findAll();
        for (BooksRegistration registration : booksRegistration) {
            booksRegistration_Request.add(BooksRegistrationUtil.convertBooksRegistrationToBooksRegistration_Request(registration));
        }
        return booksRegistration_Request;
    }

    @Override
    public BooksRegistration_Request registerBook(BooksRegistration_Request booksRegistration_request) {
        BooksInventory availableBooksInInventory = null;
        int userId = Integer.parseInt(booksRegistration_request.getUserId());
        int bookId = Integer.parseInt(booksRegistration_request.getBookId());
        Optional<Users> userObj = userRepo.findById(userId);
        Optional<BooksInventory> bookObj = booksInventoryRepo.findById(bookId);

        availableBooksInInventory = bookObj.orElseGet(BooksInventory::new);
        if (bookObj.isPresent() && userObj.isPresent() && availableBooksInInventory.getAvailableBooks() > 0) {
            BooksRegistration booksRegistration = booksRegistrationRepository.save(BooksRegistrationUtil.convertBooksRegistration_RequestToBooksRegistration(booksRegistration_request));
            // Calling book transaction
            booksTransactionService.addTransaction(BooksTransactionUtil.getBooksTransaction_Request(booksRegistration.getRegistrationId(), booksRegistration.getRegistrationDate()));

            if (booksRegistration != null) {
                int restNoOfBooks = availableBooksInInventory.getAvailableBooks() - 1;
                availableBooksInInventory.setAvailableBooks(restNoOfBooks);
                booksInventoryService.updateBook(BooksInventoryUtil.convert_BooksInventory_To_BooksInventory_Request(availableBooksInInventory));
            }
            return BooksRegistrationUtil.convertBooksRegistrationToBooksRegistration_Request(booksRegistration);
        } else {
            return null;
        }
    }

    @Override
    public BooksRegistration_Request getBooksById(int id) {
        Optional<BooksRegistration> booksRegistration = booksRegistrationRepository.findById(id);
        return BooksRegistrationUtil.convertBooksRegistrationToBooksRegistration_Request(booksRegistration.orElse(null));
    }

    @Override
    public void deleteBook(int id) {
        booksRegistrationRepository.deleteById(id);
    }

    @Override
    public BooksRegistration_Request updateRegistration(BooksRegistration_Request booksRegistration_request) {
        Optional<BooksRegistration> existingBookRegistration = booksRegistrationRepository.findById(booksRegistration_request.getRegistrationId());
        BooksRegistration booksRegistration = null;
        if (existingBookRegistration.isPresent()) {
            booksRegistration = existingBookRegistration.get();
            booksRegistration.setBookId(booksRegistration_request.getBookId());
            booksRegistration.setUserId(booksRegistration_request.getUserId());
            booksRegistration.setRegistrationDate(booksRegistration_request.getRegistrationDate());
            booksRegistrationRepository.save(booksRegistration);
        }
        return booksRegistration != null ? BooksRegistrationUtil.convertBooksRegistrationToBooksRegistration_Request(booksRegistration) : new BooksRegistration_Request();
    }
}

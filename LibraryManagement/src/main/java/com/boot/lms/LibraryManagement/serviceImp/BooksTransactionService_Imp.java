package com.boot.lms.LibraryManagement.serviceImp;

import com.boot.lms.LibraryManagement.Service.BooksTransactionService;
import com.boot.lms.LibraryManagement.Util.BooksTransactionUtil;
import com.boot.lms.LibraryManagement.entity.BooksTransaction;
import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
import com.boot.lms.LibraryManagement.repository.BooksRegistrationRepository;
import com.boot.lms.LibraryManagement.repository.BooksTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksTransactionService_Imp implements BooksTransactionService {
    @Autowired
    BooksTransactionRepo booksTransactionRepo;
    @Autowired
    BooksRegistration_Request booksRegistration_request;
    @Autowired
    BooksRegistrationRepository booksRegistrationRepository;

    public BooksTransaction_Request addTransaction(BooksTransaction_Request booksTransaction_Request) {
        BooksTransaction booksTransaction = booksTransactionRepo.save(BooksTransactionUtil.convertBooksTransaction_RequestToBooksTransaction(booksTransaction_Request));
        return BooksTransactionUtil.convertBooksTransactionToBooksTransaction_Request(booksTransaction);
    }

    @Override
    public List<BooksTransaction_Request> getAllTransactions() {

        List<BooksTransaction> list = booksTransactionRepo.findAll();
        List<BooksTransaction_Request> reqList = new ArrayList<>();
        for (BooksTransaction booksTransaction : list) {
            reqList.add(updateTransaction(booksTransaction.getTransactionId()));
        }
        return reqList;
    }

    @Override
    public BooksTransaction_Request getTransactionById(int id) {
        return updateTransaction(id);
    }

    @Override
    public void deleteTransaction(int id) {
        booksTransactionRepo.deleteById(id);
    }

    public BooksTransaction_Request updateTransaction(int transactionId) {
        LocalDateTime currentDate = LocalDateTime.now();
        Optional<BooksTransaction> existingBooksTransaction = booksTransactionRepo.findById(transactionId);
        BooksTransaction booksTransaction = existingBooksTransaction.orElseGet(BooksTransaction::new);

        /** Current date is lessthen Return date then fine is == 0*/
        if (currentDate.isAfter(booksTransaction.getIssueDate()) && currentDate.isBefore(booksTransaction.getReturnDate())) {
            booksTransaction.setFine(0);
            booksTransaction.setReturnDate(currentDate);
        }
        /** Current date is greaterThen Return date then fine *1*/
        else{
            Duration duration = Duration.between(booksTransaction.getReturnDate(), currentDate);
            booksTransaction.setFine((double) duration.toDays() * 1);
            booksTransaction.setReturnDate(currentDate);
        }
        return BooksTransactionUtil.convertBooksTransactionToBooksTransaction_Request(booksTransactionRepo.save(booksTransaction));
    }

}

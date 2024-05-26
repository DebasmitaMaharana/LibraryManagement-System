package com.boot.lms.LibraryManagement.serviceImp;

import com.boot.lms.LibraryManagement.Service.BooksInventoryService;
import com.boot.lms.LibraryManagement.Util.BooksInventoryUtil;
import com.boot.lms.LibraryManagement.entity.BooksInventory;
import com.boot.lms.LibraryManagement.objects.BooksInventory_Request;
import com.boot.lms.LibraryManagement.repository.BooksInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksInventoryService_Imp implements BooksInventoryService {
    @Autowired
    BooksInventoryRepo booksInventoryRepo;
    @Autowired
    BooksInventory booksInventory;

    @Override
    public List<BooksInventory_Request> getAllBooks() {
        List<BooksInventory_Request> booksInventory_requests = new ArrayList<>();
        List<BooksInventory> booksInventoryList = booksInventoryRepo.findAll();


        for (BooksInventory booksInventory : booksInventoryList) {
            booksInventory_requests.add(BooksInventoryUtil.convert_BooksInventory_To_BooksInventory_Request(booksInventory));
        }

        return booksInventory_requests;
    }

    @Override

    public BooksInventory_Request save(BooksInventory_Request booksInventory_request) {
        BooksInventory booksInventory = booksInventoryRepo.save(BooksInventoryUtil.convertBooksInventory_Request_To_BooksInventory(booksInventory_request));
        return BooksInventoryUtil.convert_BooksInventory_To_BooksInventory_Request(booksInventory);
    }

    @Override
    public BooksInventory_Request findById(int id) {
        Optional<BooksInventory> booksInventory = booksInventoryRepo.findById(id);
        return BooksInventoryUtil.convert_BooksInventory_To_BooksInventory_Request(booksInventory.orElse(null));
    }

    @Override

    public void deleteALLBooksById(int id) {
        booksInventoryRepo.deleteById(id);


    }

    @Override
    public BooksInventory_Request updateBook(BooksInventory_Request booksInventory_Request) {
        Optional<BooksInventory> existingBook = booksInventoryRepo.findById(booksInventory_Request.getBookId());
        BooksInventory booksInventory = null;
        if (existingBook.isPresent()) {
            booksInventory = existingBook.get();
            booksInventory.setBookName(booksInventory_Request.getBookName());
            booksInventory.setNoOfBooks(booksInventory_Request.getNoOfBooks());
            booksInventory.setPublisher(booksInventory_Request.getPublisher());
            booksInventory.setAuthor1(booksInventory_Request.getAuthor1());
            booksInventory.setAuthor2(booksInventory_Request.getAuthor2());
            booksInventory.setYearOfPublication(booksInventory_Request.getYearOfPublication());
            booksInventoryRepo.save(booksInventory);

        }
        return booksInventory != null ? BooksInventoryUtil.convert_BooksInventory_To_BooksInventory_Request(booksInventory) : new BooksInventory_Request();
    }


}

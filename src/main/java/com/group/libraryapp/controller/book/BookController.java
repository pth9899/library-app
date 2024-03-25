package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.Book;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnReqeust;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/book")
    public List<Book> findAllBook(){
        return bookService.findAllBook();
    }
   @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
   }
   @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request);
   }
    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnReqeust request){
        bookService.returnBook(request);
    }
}
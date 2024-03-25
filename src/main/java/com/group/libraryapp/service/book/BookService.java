package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.Book;
import com.group.libraryapp.dto.book.BookRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnReqeust;
import com.group.libraryapp.dto.user.response.User;
import com.group.libraryapp.dto.user.response.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }
    @Transactional
    public void loanBook(BookLoanRequest request){
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalAccessError::new);
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)){
            throw new IllegalArgumentException();
        }
        User user = userRepository.findByName(request.getUserName());
            if(user==null){
                throw new IllegalArgumentException();
            }
        user.loanBook(book.getName());
    }
    @Transactional
    public void returnBook(BookReturnReqeust request){
        User user = userRepository.findByName(request.getUserName());
        if(user==null){
            throw new IllegalArgumentException();
        }
        user.returnBook(request.getBookName());
    }
}

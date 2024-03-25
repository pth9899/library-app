package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.BookRepository;
import com.group.libraryapp.dto.user.response.UserRepository;
import com.group.libraryapp.service.book.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserServiceV2Test extends BookService {
    UserServiceV2 userServiceV2;

    UserRepository userRepository;

    public UserServiceV2Test(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        super(bookRepository, userLoanHistoryRepository, userRepository);
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void updateUser() {
    }

    @Test
    @Transactional
    void deleteUser() {
        String User ="1L";
        userServiceV2.deleteUser(User);
        verify(userRepository).deleteAll();
    }
}
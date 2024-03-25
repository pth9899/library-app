package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.dto.user.response.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;
    protected UserLoanHistory(){

    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = true;
    }


    public void doReturn(){
        this.isReturn = true;
    }
    public String getBookName(){
        return this.bookName;
    }
}

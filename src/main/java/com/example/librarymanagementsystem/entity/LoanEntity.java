package com.example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookEntity book;

    @ManyToOne
    private BorrowerEntity borrower;

    private LocalDate loanDate;
    private LocalDate dueDate;

    // Default constructor
    public LoanEntity() {}

    // Parameterized constructor
    public LoanEntity(BookEntity book, BorrowerEntity borrower, LocalDate loanDate, LocalDate dueDate) {
        this.book = book;
        this.borrower = borrower;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public BorrowerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerEntity borrower) {
        this.borrower = borrower;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}


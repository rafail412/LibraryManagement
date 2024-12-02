package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.entity.LoanEntity;
import com.example.librarymanagementsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/b1/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<LoanEntity>> getAllLoans() {
        List<LoanEntity> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanEntity> getLoanById(@PathVariable Long id) {
        LoanEntity loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<LoanEntity> createLoan(@RequestBody LoanEntity loan) {
        LoanEntity newLoan = loanService.createLoan(loan);
        return ResponseEntity.ok(newLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanEntity> updateLoan(@PathVariable Long id, @RequestBody LoanEntity loan) {
        LoanEntity updatedLoan = loanService.updateLoan(id, loan);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}


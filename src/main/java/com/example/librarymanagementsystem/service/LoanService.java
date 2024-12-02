package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.entity.LoanEntity;
import com.example.librarymanagementsystem.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanEntity saveLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    public List<LoanEntity> getAllLoans() {
        return loanRepository.findAll();
    }

    public LoanEntity getLoanById(Long id) {
        return loanRepository.findById(id).get();
    }

    public LoanEntity createLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    public LoanEntity updateLoan(Long id, LoanEntity loan) {
        LoanEntity existingLoan = null;
        return loanRepository.save(existingLoan);
    }

    public void deleteLoan(Long id) {

        loanRepository.deleteById(id);
    }
}


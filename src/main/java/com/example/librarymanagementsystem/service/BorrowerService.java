package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.BorrowerEntity;
import com.example.librarymanagementsystem.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    // Save a borrower
    public BorrowerEntity saveBorrower(BorrowerEntity borrower) {
        return borrowerRepository.save(borrower);
    }

    // Get all borrowers
    public List<BorrowerEntity> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    // Update a borrower by ID
    public BorrowerEntity updateBorrower(Long id, BorrowerEntity borrowerDetails) {
        Optional<BorrowerEntity> optionalBorrower = borrowerRepository.findById(id);

        if (optionalBorrower.isPresent()) {
            BorrowerEntity existingBorrower = optionalBorrower.get();
            // Update fields
            existingBorrower.setName(borrowerDetails.getName());
            existingBorrower.setEmail(borrowerDetails.getEmail());
            return borrowerRepository.save(existingBorrower);
        } else {
            throw new RuntimeException("Borrower with ID " + id + " not found");
        }
    }

    // Delete a borrower by ID
    public boolean deleteBorrower(Long id) {
        if (borrowerRepository.existsById(id)) {
            borrowerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public BorrowerEntity getBorrowerById(Long id) {

        return borrowerRepository.findById(id).get();

    }
}




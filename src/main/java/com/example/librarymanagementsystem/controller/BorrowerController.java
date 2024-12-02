package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.BorrowerEntity;
import com.example.librarymanagementsystem.service.BorrowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    // Endpoint to create a new borrower
    @PostMapping
    public ResponseEntity<BorrowerEntity> createBorrower(@RequestBody BorrowerEntity borrower) {
        BorrowerEntity savedBorrower = borrowerService.saveBorrower(borrower);
        return ResponseEntity.ok(savedBorrower);
    }

    // Endpoint to retrieve all borrowers
    @GetMapping
    public ResponseEntity<List<BorrowerEntity>> getAllBorrowers() {
        List<BorrowerEntity> borrowers = borrowerService.getAllBorrowers();
        return ResponseEntity.ok(borrowers);
    }

    // Endpoint to retrieve a borrower by ID
    @GetMapping("/{id}")
    public ResponseEntity<BorrowerEntity> getBorrowerById(@PathVariable Long id) {
        BorrowerEntity borrower = borrowerService.getBorrowerById(id);
        if (borrower != null) {
            return ResponseEntity.ok(borrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to update an existing borrower
    @PutMapping("/{id}")
    public ResponseEntity<BorrowerEntity> updateBorrower(@PathVariable Long id, @RequestBody BorrowerEntity borrowerDetails) {
        BorrowerEntity updatedBorrower = borrowerService.updateBorrower(id, borrowerDetails);
        if (updatedBorrower != null) {
            return ResponseEntity.ok(updatedBorrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a borrower by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
        boolean isDeleted = borrowerService.deleteBorrower(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.BorrowerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface BorrowerRepository {
    BorrowerEntity save(BorrowerEntity borrower);

    List<BorrowerEntity> findAll();

    Optional<BorrowerEntity> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
}

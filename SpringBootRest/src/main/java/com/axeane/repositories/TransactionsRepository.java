package com.axeane.repositories;

import com.axeane.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {

    Transaction findCompteById(Long id);
    Page<Transaction> findByNumerocompteId(Long numerocompteId, Pageable pageable);

    @Query("select c from Transaction c where c.numerocompte.id = :numerocompteId")
    Page<List<Transaction>>  findComptesByNumerocompte(Long numerocompteId, Pageable pageable);






}
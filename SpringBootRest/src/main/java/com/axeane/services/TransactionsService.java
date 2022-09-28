package com.axeane.services;

import com.axeane.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TransactionsService {
    void addcompte(Transaction compte);

    List<Transaction> getListComptes();

    Transaction findComptedById(Long searchedId);
    void deleteCompted(Long id);
    void updateCompte(Transaction compte);

    void addcompte(Long numerocompteId, Transaction compte);

    Page<Transaction> getAllComptesByNumerocomptetId(Long numerocompteId,
                                                     Pageable pageable);

    Transaction findCompteById(Long id);

    void deleteCompted(Long numerocompteId, Long compteId);

    void updateCompte(Long numerocompteId, Transaction transaction);

    Page<List<Transaction>> findComptesByNumerocompte(Long numerocompteId, Pageable pageable);
}

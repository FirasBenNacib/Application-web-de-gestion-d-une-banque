package com.axeane.services;
import com.axeane.model.Transaction;
import com.axeane.repositories.TransactionsRepository;
import com.axeane.repositories.NumerocomptesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private final NumerocomptesRepository numerocomptesRepository;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository, NumerocomptesRepository numerocomptesRepository) {
        this.transactionsRepository = transactionsRepository;
        this.numerocomptesRepository = numerocomptesRepository;
    }
    private  Logger logger = LoggerFactory.getLogger(TransactionsServiceImpl.class);

    @Override
    public void addcompte(Transaction compte) {

    }

    @Override
    public List<Transaction> getListComptes() {
        return null;
    }

    @Override
    public Transaction findComptedById(Long searchedId) {
        return null;
    }

    @Override
    public void deleteCompted(Long id) {

    }

    @Override
    public void updateCompte(Transaction compte) {

    }

    @Override
    public void addcompte(Long numerocompteId, Transaction compte) {
        numerocomptesRepository.findById(numerocompteId).map(numerocompte -> {
            compte.setNumerocompte(numerocompte);
            return transactionsRepository.save(compte);
        });
    }

    @Override
    public Page<Transaction> getAllComptesByNumerocomptetId(Long numerocompteId,
                                                            Pageable pageable) {

        return transactionsRepository.findByNumerocompteId(numerocompteId, pageable);
    }

    @Override
    public Transaction findCompteById(Long id) {
        return transactionsRepository.findCompteById(id);
    }




    @Override
    public void deleteCompted(Long numerocompteId, Long compteId) {

        transactionsRepository.findById(compteId).map(compte -> {
            transactionsRepository.delete(compte);
            return compte;
        });
    }

    @Override
    public void updateCompte(Long numerocompteId, Transaction compteRequest) {

        transactionsRepository.findById(compteRequest.getId()).map(compte
                -> {
            compte.setLibellé(compteRequest.getLibellé());
            compte.setDate_operation(compteRequest.getDate_operation());
            compte.setMontant(compteRequest.getMontant());
            return transactionsRepository.save(compte);
        });
    }

    @Override
    public Page<List<Transaction>> findComptesByNumerocompte(Long numerocompteId, Pageable pageable) {
        return transactionsRepository.findComptesByNumerocompte(numerocompteId,pageable);
    }
}

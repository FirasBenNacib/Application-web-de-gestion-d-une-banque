package com.axeane.services;

import com.axeane.model.Numerocompte;
import com.axeane.repositories.AgenceRepository;
import com.axeane.repositories.NumerocomptesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NumerocomptesServiceImpl implements NumerocomptesService{
    @Autowired
    private NumerocomptesRepository numerocomptesRepository;

    @Autowired
    private final AgenceRepository agenceRepository;

    public NumerocomptesServiceImpl(NumerocomptesRepository numerocomptesRepository, AgenceRepository agenceRepository) {
        this.numerocomptesRepository = numerocomptesRepository;
        this.agenceRepository = agenceRepository;
    }
    private  Logger logger = LoggerFactory.getLogger(TransactionsServiceImpl.class);

    @Override
    public void addnumerocompte(Numerocompte numerocompte) {

    }

    @Override
    public List<Numerocompte> getListNumerocomptes() {
        return null;
    }

    @Override
    public Numerocompte findNumerocomptedById(Long searchedId) {
        return null;
    }

    @Override
    public Numerocompte findNumercomptedById(Long searchedId) {
        return null;
    }

    @Override
    public void deleteNumerocompted(Long id) {

    }

    @Override
    public void updateNumerocompted(Numerocompte numerocompte) {

    }

    @Override
    public void addnumerocompted(Long agenceId, Numerocompte numerocompte) {

    }

    @Override
    public void updateNumerocompte(Numerocompte numerocompte) {

    }

    @Override
    public void addnumerocompte(Long agenceId, Numerocompte numerocompte) {
        agenceRepository.findById(agenceId).map(agence -> {
            numerocompte.setAgence(agence);
            return numerocomptesRepository.save(numerocompte);
        });
    }

    @Override
    public Numerocompte findNumeroCompteById(Long id) {
        return null;
    }

    @Override
    public Page<Numerocompte> getAllNumerocomptesByAgencetId(Long agenceId,
                                                       Pageable pageable) {

        return numerocomptesRepository.findByAgenceId(agenceId, pageable);
    }

    @Override
    public Numerocompte findNumerocompteById(Long id) {
        return numerocomptesRepository.findNumerocompteById(id);
    }




    @Override
    public void deleteNumerocompted(Long agenceId, Long numerocompteId) {

        numerocomptesRepository.findById(numerocompteId).map(numerocompte -> {
            numerocomptesRepository.delete(numerocompte);
            return numerocompte;
        });
    }

    @Override
    public void updateCompte(Long agenceId, Numerocompte numerocompte) {

    }

    @Override
    public void updateNumerocompte(Long agenceId, Numerocompte numerocompteRequest) {

        numerocomptesRepository.findById(numerocompteRequest.getId()).map(numerocompte
                -> {
            numerocompte.setNumero(numerocompteRequest.getNumero());
            return numerocomptesRepository.save(numerocompte);
        });
    }

    @Override
    public Page<List<Numerocompte>> findNumerocomptesByAgence(Long agenceId, Pageable pageable) {
        return numerocomptesRepository.findNumerocomptesByAgence(agenceId,pageable);
    }

    @Override
    public Page<Numerocompte> getAllNumerocomptesByNumerocomptetId(Long numerocompteId, Pageable pageable) {
        return null;
    }
}



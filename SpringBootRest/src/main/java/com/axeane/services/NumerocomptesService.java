package com.axeane.services;

import com.axeane.model.Numerocompte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NumerocomptesService {
    void addnumerocompte(Numerocompte numerocompte);

    List<Numerocompte> getListNumerocomptes();

    Numerocompte findNumerocomptedById(Long searchedId);
    void deleteNumerocompted(Long id);
    void updateNumerocompted(Numerocompte numerocompte);

    void addnumerocompted(Long agenceId, Numerocompte numerocompte);

    Page<Numerocompte> getAllNumerocomptesByAgencetId(Long numerocompteId,
                                                Pageable pageable);

    Numerocompte findNumercomptedById(Long searchedId);

    void updateNumerocompte(Numerocompte numerocompte);

    void addnumerocompte(Long agenceId, Numerocompte numerocompte);

    Numerocompte findNumeroCompteById(Long id);

    Numerocompte findNumerocompteById(Long id);

    void deleteNumerocompted(Long agenceId, Long numerocompteId);

    void updateCompte(Long agenceId, Numerocompte numerocompte);

    void updateNumerocompte(Long agenceId, Numerocompte numerocompteRequest);

    Page<List<Numerocompte>> findNumerocomptesByAgence(Long numerocompteId, Pageable pageable);

    Page<Numerocompte> getAllNumerocomptesByNumerocomptetId(Long numerocompteId,
                                                Pageable pageable);
}
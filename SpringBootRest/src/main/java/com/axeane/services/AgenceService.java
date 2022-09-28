package com.axeane.services;

import com.axeane.model.Agence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgenceService {
    void createAgence(Agence agence);

    Page<Agence> getAllAgences(Pageable pageable);

    void deleteAgence(Long agenceId);

    void updateAgence(Agence agenceRequest);


    Agence registerAgence(Agence agence);
}
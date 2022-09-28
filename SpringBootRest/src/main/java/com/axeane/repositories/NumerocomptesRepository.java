package com.axeane.repositories;

import com.axeane.model.Numerocompte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NumerocomptesRepository extends JpaRepository<Numerocompte, Long> {
    Numerocompte findNumerocompteById(Long id);
    Page<Numerocompte> findByAgenceId(Long agenceId, Pageable pageable);

    @Query("select n from Numerocompte n where n.agence.id = :agenceId")
    Page<List<Numerocompte>>  findNumerocomptesByAgence(Long agenceId, Pageable pageable);






}


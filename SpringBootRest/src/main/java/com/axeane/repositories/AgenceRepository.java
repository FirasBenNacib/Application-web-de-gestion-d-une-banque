package com.axeane.repositories;

import com.axeane.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long>  {

    Agence findAgenceById(Long id);
}

package com.axeane.repositories;

import com.axeane.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    List<Utilisateur> findByUsername(String username); //required method

    @Modifying
    @Query("delete from Utilisateur t where t.id = ?1")
    void deleteById(Long entityId);
}

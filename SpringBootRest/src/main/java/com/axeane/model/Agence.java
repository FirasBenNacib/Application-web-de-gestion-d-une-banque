package com.axeane.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "agence")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "agence")
    private Set<Numerocompte> numerocomptes = new HashSet<>();

    public Set<Numerocompte> getNumerocomptes() {
        return numerocomptes;
    }

    public void setNumerocomptes(Set<Numerocompte> numerocomptes) {
        this.numerocomptes = numerocomptes;
    }

}

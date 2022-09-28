package com.axeane.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
@Entity
@Table(name = "numerocompte")
public class Numerocompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final AtomicInteger count = new AtomicInteger(0);
    private String numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id", nullable = false)
    private Agence agence;
    @JsonIgnore
    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    public Numerocompte() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Numerocompte(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }


    public Numerocompte(String numero) {
        this.numero = numero;
        id = Long.valueOf(count.incrementAndGet());
    }

    @Override
    public String toString() {
        return "numerocompte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numerocompte)) return false;
        Numerocompte numerocompte = (Numerocompte) o;
        return getId() == numerocompte.getId() &&
                Objects.equals(getNumero(), numerocompte.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumero());
    }
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "numerocompte")
    private Set<Transaction> comptes = new HashSet<>();

    public Set<Transaction> getComptes() {
        return comptes;
    }

    public void settransaction(Set<Transaction> comptes) {
        this.comptes = comptes;
    }
}

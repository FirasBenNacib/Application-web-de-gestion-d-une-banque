package com.axeane.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final AtomicInteger count = new AtomicInteger(0);

    private String libellé;

    private BigDecimal montant;
    private String date_operation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numerocompte_id", nullable = false)
    private Numerocompte numerocompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }


    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getDate_operation() {
        return date_operation;
    }

    @Required
    public void setDate_operation(String date_operation) {

        this.date_operation = date_operation;
    }
    @JsonIgnore
    public Numerocompte getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(Numerocompte numerocompte) {
        this.numerocompte = numerocompte;
    }

    public Transaction() {
    }

    public Transaction(Long id, String libellé, BigDecimal montant, String date_operation) {
        this.id = id;
        this.libellé = libellé;
        this.montant = montant;
        this.date_operation = date_operation;
    }

    public Transaction(String libellé, BigDecimal montant, String date_operation) {
        this.libellé = libellé;
        this.montant = montant;
        this.date_operation = date_operation;
        id = Long.valueOf(count.incrementAndGet());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", libellé='" + libellé + '\'' +
                ", montant=" + montant +
                ", date_operation='" + date_operation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction compte = (Transaction) o;
        return getId() == compte.getId() &&
                Objects.equals(getLibellé(), compte.getLibellé()) &&
                Objects.equals(getMontant(), compte.getMontant()) &&
                Objects.equals(getDate_operation(), compte.getDate_operation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLibellé(), getMontant(), getDate_operation());
    }
}

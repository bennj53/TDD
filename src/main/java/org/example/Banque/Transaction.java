package org.example.Banque;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    LocalDateTime date;
    int somme;
    int solde;

    public Transaction(LocalDateTime date, int somme, int solde) {
        this.date = date;
        this.somme = somme;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return date + " | " +  somme + " | " + solde;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, somme, solde);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return somme == transaction.somme &&
                solde == transaction.solde &&
                date.equals(transaction.date);
    }
}

package org.example.Banque;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    private int solde;
    private List<Transaction> transactions;
    private int id;

    private DateService dateService;
    private String iban;

    public Compte() {
    }

    public Compte(int solde, int id, DateService dateService, String iban) {
        this.id = id;
        this.solde = solde;
        this.transactions = new ArrayList<>();
        this.dateService = dateService;
        this.iban = iban;
    }

    public int getSolde() {
        return solde;
    }

    public void depot(int somme) {
        this.solde+=somme;
        ajouterTransaction(somme);
    }

    public void retrait(int somme) {
        if (somme <= solde){
            this.solde-=somme;
            ajouterTransaction(somme*-1);
        }
        //throw Exception("");
    }

    public void ajouterTransaction(int somme) {
        Transaction transaction = new Transaction(dateService.getDateNow(), somme, this.solde);
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }
}

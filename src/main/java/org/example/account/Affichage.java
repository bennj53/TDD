package org.example.account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Affichage {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
    private List<Transaction> lastTransactions = new LinkedList<>();

    public void afficher(List<Transaction> transactions) {
        lastTransactions.clear();
        System.out.println("DATE | TRANSACTION | SOLDE");
        transactions.stream()
                .sorted((t1, t2) -> t2.date.compareTo(t1.date))
                .forEach(t -> {
                    String dateFormatee = this.formaterDate(t.date);
                    System.out.printf("%s | %s | %s%n", dateFormatee, t.somme, t.solde);
                    lastTransactions.add(t);
                });
    }

    public String formaterDate(LocalDateTime localDateTime) {
        return localDateTime.format(this.formatter);
    }

    public List<Transaction> getLastTransactions() {
        return lastTransactions;
    }
}

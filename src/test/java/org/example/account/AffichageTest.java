package org.example.account;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AffichageTest extends TestCase {

    public void test_afficher_les_transactions_de_la_plus_recente_a_la_plus_ancienne(){
        //Given
        Affichage affichage = new Affichage();
        LocalDateTime dateLaPlusAncienne = LocalDateTime.now().minusDays(2);
        LocalDateTime dateLaPlusRecente = LocalDateTime.now();
        LocalDateTime dateIntermediaire= LocalDateTime.now().minusDays(1);

        Transaction transactionLaPlusRecente = new Transaction(dateLaPlusRecente, 1000, 1000);
        Transaction transactionLaPlusAncienne = new Transaction(dateLaPlusAncienne, 100, 100);
        Transaction transactionIntermediaire = new Transaction(dateIntermediaire, -100, 0);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transactionIntermediaire);
        transactions.add(transactionLaPlusRecente);
        transactions.add(transactionLaPlusAncienne);

        //When
        affichage.afficher(transactions);

        //Then
        assertEquals(affichage.getLastTransactions().get(0), transactionLaPlusRecente);
        assertEquals(affichage.getLastTransactions().get(1), transactionIntermediaire);
        assertEquals(affichage.getLastTransactions().get(2), transactionLaPlusAncienne);
    }

    public void test_mettre_une_date_au_format_ddMMyyyy(){
        //Given
        Affichage affichage = new Affichage();
        LocalDateTime date = LocalDateTime.of(2023, 12, 21, 12, 00, 00, 000);
        String dateAttendue = "21/12/2023 12:00:00.000";
        //When
        String resultat = affichage.formaterDate(date);

        //Then
        assertEquals(dateAttendue, resultat);
    }
}
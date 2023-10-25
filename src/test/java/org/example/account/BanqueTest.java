package org.example.account;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class BanqueTest extends TestCase {
    Affichage affichage = new Affichage();

/*    public void test_avoir_un_compte_non_null() {
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        //When
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        //Then
        assertNotNull(compte);
    }

    public void test_afficher_solde_du_compte(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        //When
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        int solde = compte.getSolde();
        //Then
        assertEquals(0, solde);
    }

   public void test_deposer_somme_sur_le_compte(){
        //Given
        Banque banque = new Banque(affichage);
       DateService dateService = new DateServiceTest();
        //When
       int idCompte = banque.creerCompte(0, dateService);
       Compte compte = banque.getCompte(idCompte);
        compte.depot(100);
        //Then
        assertEquals(100, compte.getSolde());
    }

   public void test_retirer_une_somme_sur_le_compte(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        //When
        int idCompte = banque.creerCompte(110, dateService);
        Compte compte = banque.getCompte(idCompte);
        compte.retrait(100);
        //Then
        assertEquals(10, compte.getSolde());
    }

    public void test_faire_un_retrait_avec_un_solde_compte_a_0(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        //When
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        compte.retrait(100);
        //Then
        assertEquals(0, compte.getSolde());
    }

    public void test_ajouter_la_transaction_d_un_depot(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        LocalDateTime dateNow = LocalDateTime.of(2023, 12, 21, 12, 00, 00, 000);
        Transaction transactionAttendu = new Transaction(dateNow, 100, 100);
        //When
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        compte.depot(100);
        //Then
        assertEquals(100, compte.getSolde());
        assertEquals(1, compte.getTransactions().size());
        assertEquals(transactionAttendu.somme, compte.getTransactions().get(0).somme);
        assertEquals(transactionAttendu.solde, compte.getTransactions().get(0).solde);
        assertEquals(transactionAttendu.date, compte.getTransactions().get(0).date);
    }

    public void test_ajouter_la_transaction_d_un_retrait(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        LocalDateTime dateNow = LocalDateTime.of(2023, 12, 21, 12, 00, 00, 000);
        Transaction transactionAttendu = new Transaction(dateNow, -50, 50);
        //When
        int idCompte = banque.creerCompte(100, dateService);
        Compte compte = banque.getCompte(idCompte);
        compte.retrait(50);
        //Then
        assertEquals(50, compte.getSolde());
        assertEquals(1, compte.getTransactions().size());
        assertEquals(transactionAttendu.somme, compte.getTransactions().get(0).somme);
        assertEquals(transactionAttendu.solde, compte.getTransactions().get(0).solde);
        assertEquals(transactionAttendu.date, compte.getTransactions().get(0).date);
    }

    public void test_afficher_toutes_transaction_du_compte(){
        //Given
        Banque banque = new Banque(affichage);
        DateService dateService = new DateServiceTest();
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        compte.depot(100);
        compte.retrait(50);
        //When
        banque.afficherLesTransactions(compte);
        //Then
        assertTrue(true);
    }*/

    public void test_faire_un_virement_OK(){
        //Given
        DateService dateService = new DateServiceTest();
        VirementService virementServiceMock = Mockito.mock(VirementService.class);
        Banque banque = new Banque(affichage, virementServiceMock);
        int idCompte = banque.creerCompte(1000, dateService);
        Compte compte = banque.getCompte(idCompte);
        String ibanTo = "XXXX-XXXX-XXXX-XXXX";
        int somme = 100;
        //When
       String result = banque.virerSomme(compte, ibanTo, somme);
        //Then
        assertEquals("202",result);

    }

    //public void test_faire_un_virement_KO_avec_montant_superieur_solde_du_compte(){
    //public void test_faire_un_virement_KO_avec_montant_negatif(){
    //public void test_faire_un_virement_KO_avec_montant_manquant(){
}
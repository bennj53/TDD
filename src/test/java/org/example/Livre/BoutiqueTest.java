package org.example.Livre;

import junit.framework.TestCase;

public class BoutiqueTest extends TestCase {

    private final String titreTome1 = "Tome 1";
    private final String titreTome2 = "Tome 2";
    private final String titreTome3 = "Tome 3";
    private final String titreTome4 = "Tome 4";
    private final String titreTome5 = "Tome 5";
    public void test_un_tome_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        boutique.ajouterAuPanier(tome1);

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(8.0, prix);
    }


    public  void test_deux_tome_different_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        Tome tome2 = new Tome(8, titreTome2);
        boutique.ajouterAuPanier(tome1);
        boutique.ajouterAuPanier(tome2);
        double prixAttendu = 15.20;

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(prixAttendu, prix);
    }


    public void test_trois_tome_different_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        Tome tome2 = new Tome(8, titreTome2);
        Tome tome3 = new Tome(8, titreTome3);
        boutique.ajouterAuPanier(tome1);
        boutique.ajouterAuPanier(tome2);
        boutique.ajouterAuPanier(tome3);
        double prixAttendu = (8+8+8)*(1-0.10);

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(prixAttendu, prix);
    }


    public void test_quattre_tome_different_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        Tome tome2 = new Tome(8, titreTome2);
        Tome tome3 = new Tome(8, titreTome3);
        Tome tome4 = new Tome(8, titreTome4);
        boutique.ajouterAuPanier(tome1);
        boutique.ajouterAuPanier(tome2);
        boutique.ajouterAuPanier(tome3);
        boutique.ajouterAuPanier(tome4);
        double prixAttendu = (8+8+8+8)*(1-0.20);

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(prixAttendu, prix);
    }

    public void test_cinq_tome_different_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        Tome tome2 = new Tome(8, titreTome2);
        Tome tome3 = new Tome(8, titreTome3);
        Tome tome4 = new Tome(8, titreTome4);
        Tome tome5 = new Tome(8, titreTome5);
        boutique.ajouterAuPanier(tome1);
        boutique.ajouterAuPanier(tome2);
        boutique.ajouterAuPanier(tome3);
        boutique.ajouterAuPanier(tome4);
        boutique.ajouterAuPanier(tome5);
        double prixAttendu = (8+8+8+8+8)*(1-0.25);

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(prixAttendu, prix);
    }

    public void test_cinq_tome_different_plus_un_en_double_acheté() {
        //Given
        Boutique boutique = new Boutique();
        Tome tome1 = new Tome(8, titreTome1);
        Tome tome1_2 = new Tome(8, titreTome1);
        Tome tome2 = new Tome(8, titreTome2);
        Tome tome3 = new Tome(8, titreTome3);
        Tome tome4 = new Tome(8, titreTome4);
        Tome tome5 = new Tome(8, titreTome5);
        boutique.ajouterAuPanier(tome1);
        boutique.ajouterAuPanier(tome1_2);
        boutique.ajouterAuPanier(tome2);
        boutique.ajouterAuPanier(tome3);
        boutique.ajouterAuPanier(tome4);
        boutique.ajouterAuPanier(tome5);
        double prixAttendu = (8+8+8+8+8)*(1-0.25) + 8*(1-0);

        //When
        double prix = boutique.calculPrix();

        //Then
        assertEquals(prixAttendu, prix);
    }
}
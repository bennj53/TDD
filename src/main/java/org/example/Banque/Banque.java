package org.example.Banque;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banque {
    private List<Compte> comptes;
    private Affichage affichage;
    private static int id = 0;
    private static long iban = 100_000_000;
    private VirementService virementService;


    public Banque(Affichage affichage, VirementService virementService) {
        this.affichage = affichage;
        this.comptes = new ArrayList<>();
        this.virementService = virementService;
    }

    public Compte getCompte(int id) {
        Compte compte = this.comptes.stream()
                .filter(t->t.getId() == id)
                .collect(Collectors.toList())
                .stream().findFirst().orElse(null);
        return compte;
    }

    public int creerCompte(int solde, DateService dateService) {
        Compte compte = new Compte(solde, ++this.id, dateService, String.valueOf(++iban));
        this.comptes.add(compte);
        return compte.getId();
    }

    public void afficherLesTransactions(Compte compte) {
        List<Transaction> transactions = compte.getTransactions();
        this.affichage.afficher(transactions);
    }

    public String virerSomme(Compte compte, String ibanTo, int somme) {
        String result = this.virementService.virement(compte.getIban(), ibanTo, somme);
        if(result.equals("202")){
            compte.retrait(somme);
        }

        return result;
    }
}

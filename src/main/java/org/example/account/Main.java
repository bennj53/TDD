package org.example.account;

import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {
        Affichage affichage = new Affichage();
        VirementService virementService = new VirementServiceImpl();
        Banque banque = new Banque(affichage, virementService);
        DateService dateService = new DateServiceImpl();
        int idCompte = banque.creerCompte(0, dateService);
        Compte compte = banque.getCompte(idCompte);
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop){
            System.out.println("\nOpérations disponibles :");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Afficher le solde");
            System.out.println("4. Quitter");

            int saisie = scanner.nextInt();

            switch (saisie){
                case 1:
                    System.out.println("Montant : ");
                    int depot = scanner.nextInt();
                    banque.getCompte(idCompte).depot(depot);
                    break;
                case 2:
                    System.out.println("Montant : ");
                    int retrait = scanner.nextInt();
                    banque.getCompte(idCompte).retrait(retrait);
                    break;
                case 3:
                    System.out.println("Solde : ");
                    banque.afficherLesTransactions(compte);
                    break;
                case 4:
                    System.out.println("Fin");
                    loop = false;
                    break;
                default:
                    System.out.println("Erreur de saisie");
            }
        }




    }
}

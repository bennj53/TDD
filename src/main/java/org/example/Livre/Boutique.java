package org.example.Livre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boutique {

    private List<Tome> panier;

    public Boutique() {
        this.panier = new ArrayList<>();
    }

    public void ajouterAuPanier(Tome tome1) {
        panier.add(tome1);
    }

    public double calculPrix() {
        List<List<Tome>> coffrets = this.listerLesCoffrets();
        List<Double> prixDesCoffrets = coffrets.stream().map(tomes -> {
                double prixDuCoffretAvantReduction = tomes.stream().map(tome->tome.getPrix()).reduce((x,y) -> x+y).get();
                double reduction = this.pourcentageReductionPourUnCoffret(tomes);
                System.out.printf("Réduction : %s",reduction);
                double prixDuCoffretAvecReduction = prixDuCoffretAvantReduction*(1-reduction);
                return prixDuCoffretAvecReduction;
        }).collect(Collectors.toList());


        return prixDesCoffrets.stream()
                .reduce((p1, p2) -> p1 + p2)
                .get();
    }

    private double pourcentageReductionPourUnCoffret(List<Tome> coffretDeTomes) {
        if(coffretDeTomes == null)
            return 0.0;

        int nbTome = coffretDeTomes.size();
        switch (nbTome){
            case 2:
                return 0.05;
            case 3:
                return 0.10;
            case 4:
                return 0.20;
            case 5:
                return 0.25;
            default:
                return 0.0;
        }
    }

    public List<List<Tome>> listerLesCoffrets() {
        List<Tome> bag = List.copyOf(panier);
        List<List<Tome>> coffrets = new ArrayList<>();

        while (bag.size() > 0) {
            List<Tome> unCoffretDeTomes = new ArrayList<>();
            bag.stream().forEach(tome -> {
                if(!leTomeEstDansLeCoffret(tome, unCoffretDeTomes)){
                    unCoffretDeTomes.add(tome);
                }
            });

            coffrets.add(unCoffretDeTomes);
            bag = bag.stream().filter(tome -> !unCoffretDeTomes.contains(tome)).collect(Collectors.toList());
        }

        return coffrets;
    }

    public boolean leTomeEstDansLeCoffret(Tome tome, List<Tome> coffret){
        if(coffret == null | coffret.size() == 0){
            return false;
        }

        long nombreDExemplaireDuTomeDansLeCoffret = coffret.stream()
                .filter(unTome -> unTome.getTitre().equals(tome.getTitre()))
                .count();

        return nombreDExemplaireDuTomeDansLeCoffret > 0 ? true : false;
    }


}

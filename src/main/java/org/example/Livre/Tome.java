package org.example.Livre;

import java.util.Objects;

public class Tome {
    private double prix;

    private String titre;
    private static long idGenere = 0;
    private long id;


    public Tome(double prix, String titre) {
        this.prix = prix;
        this.titre = titre;
        this.id = ++idGenere;
    }

    public double getPrix() {
        return prix;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tome tome = (Tome) o;
        return Double.compare(tome.prix, prix) == 0 && titre.equals(tome.titre) && Long.compare(tome.id, id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prix, titre);
    }

}

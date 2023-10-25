package org.example.Tennis;

public class Player {
    private String name;
    private int nbPoint =0;

    public Player(String name, int nbPoint) {
        this.name = name;
        this.nbPoint = nbPoint;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }
}

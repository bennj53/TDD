package org.example.Tennis;

public class Game {
    private Player player1;
    private Player player2;

    private final static int LOVE = 0;
    private final static int FIFTEEN = 1;
    private final static int THIRTY = 2;
    private final static int FORTY = 3;
    private final static int ADVANTAGE = 4;
    private final static int WIN = 5;



    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        int nbPointJoueur1 = this.player1.getNbPoint();
        int nbPointJoueur2 = this.player2.getNbPoint();

        if (this.playerWin()) {
            return this.bestScore().getName() + " win";
        }

        if (this.deuce()) {
            return "Deuce";
        }

        if (this.advantage()) {
            return "ADVANTAGE " + this.bestScore().getName();
        }

        return this.formatScore(nbPointJoueur1) + "-" + this.formatScore(nbPointJoueur2);
    }

    private boolean advantage() {
        int nbPointJoueur1 = this.player1.getNbPoint();
        int nbPointJoueur2 = this.player2.getNbPoint();

        if (nbPointJoueur1 == ADVANTAGE && nbPointJoueur2 == FORTY || nbPointJoueur2 == ADVANTAGE && nbPointJoueur1 == FORTY) {
            return true;
        }

        return false;
    }

    private boolean deuce() {

        if (this.player1.getNbPoint() == this.player2.getNbPoint()
                && this.player1.getNbPoint() > FORTY) {
            this.player1.setNbPoint(FORTY);
            this.player2.setNbPoint(FORTY);
        }

        if (this.player1.getNbPoint() == FORTY
                && this.player2.getNbPoint() == FORTY) {
            return true;
        }

        return false;
    }

    public void marquePoint(Player player) {
        int playerPoint = player.getNbPoint();
        player.setNbPoint(++playerPoint);
    }

    public String formatScore(int score) {
        switch (score) {
            case LOVE:
                return "love";
            case FIFTEEN:
                return "15";
            case THIRTY:
                return "30";
            case FORTY:
                return "40";
            default:
                throw new IllegalArgumentException("Illegal score: " + score);
        }
    }

    public boolean playerWin() {
        int nbPointJoueur1 = this.player1.getNbPoint();
        int nbPointJoueur2 = this.player2.getNbPoint();

        if (nbPointJoueur1 == ADVANTAGE && nbPointJoueur2 < FORTY || nbPointJoueur1 == WIN && nbPointJoueur2 == FORTY) {
            return true;
        }

        if (nbPointJoueur2 == ADVANTAGE && nbPointJoueur1 < FORTY || nbPointJoueur2 == WIN && nbPointJoueur1 == FORTY) {
            return true;
        }

        return false;
    }

    public Player bestScore() {
        if (this.player1.getNbPoint() > this.player2.getNbPoint()) {
            return player1;
        }

        return player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}

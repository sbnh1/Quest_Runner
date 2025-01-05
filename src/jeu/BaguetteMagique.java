package jeu;

public class BaguetteMagique extends Arme {
    private int soin;

    public BaguetteMagique(String nom, int degat, double poids) {
        super(nom, degat, poids);
        this.soin = 10;
    }

    public BaguetteMagique(String nom, int degat, double poids, int soin) {
        super(nom, degat, poids);
        this.soin = soin;
    }
}


package jeu;

public class BaguetteMagique extends Arme {
    private int soin;

    public BaguetteMagique(String nom, int degat, double poids) {
        super(nom, degat, poids);
        this.soin = 5;
    }

    public BaguetteMagique(String nom, int degat, double poids, int soin) {
        super(nom, degat, poids);
        this.soin = soin;
    }

    public int getSoin() {
        return soin;
    }

    public void setSoin(int soin) {
        this.soin = soin;
    }
}


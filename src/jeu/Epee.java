package jeu;

public class Epee extends Arme {
    private int longueur;

    public Epee(String nom, int degat, double poids, int longueur) {
        super(nom, degat, poids);
        this.longueur = longueur;
    }

    public Epee(String nom, int degat, double poids){
        super(nom, degat, poids);
        this.longueur = 10;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}


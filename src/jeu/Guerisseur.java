package jeu;

public class Guerisseur extends Personnage {
    private int sagesse;

    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = 10;
    }

    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme, int sagesse) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = sagesse;
    }

    public int getSagesse() {
        return sagesse;
    }

    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }
}
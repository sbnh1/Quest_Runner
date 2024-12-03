package jeu;

public class Sorcier extends Personnage {
    private int intelligence;

    public Sorcier(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
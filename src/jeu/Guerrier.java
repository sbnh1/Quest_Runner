package jeu;

public class Guerrier extends Personnage {
    private int force;

    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = 10;
    }

    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme, int force) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
}
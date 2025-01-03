package jeu;

import visiteur.VisiteurPerso;

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

    public void augmenterLvl(){
        this.force += 3;
        this.pointsDeVie += 10;
        this.pointDeVieDeBase += 10;
        this.niveau += 1;
    }

    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

}

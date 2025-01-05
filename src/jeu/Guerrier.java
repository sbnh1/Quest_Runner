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

    @Override
    public void accept(VisiteurPerso v) {
        v.visite(this);
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
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterDegat(10);
    }

    public void augmenterDegat(){
        arme.augmenterDegat(15);
    }

    public void diminuerDegat(){
        arme.augmenterDegat(-15);
    }

    public void augmenterDefense(){
        this.defense += 10;
    }

    public void diminuerDefense(){
        this.defense -= 10;
    }
}

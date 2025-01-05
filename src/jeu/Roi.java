package jeu;

import visiteur.VisiteurPerso;

public class Roi extends Personnage {
    private int force;
    private String royaume;

    public Roi(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = 10;
        this.royaume = "royaume1";
    }

    public Roi(int pointsDeVie, int niveau, String nom, Arme arme, int force, String royaume) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
        this.royaume = royaume;
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

    public String getRoyaume() {
        return royaume;
    }

    public void setRoyaume(String royaume) {
        this.royaume = royaume;
    }

    public void augmenterLvl(){
        this.force += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterSoin(2);
        this.getArme().augmenterDegat(10);
    }

    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

    public void diminuerDegat(){
        arme.augmenterDegat(-5);
    }

    public void augmenterDefense(){
        this.defense += 20;
    }

    public void diminuerDefense(){
        this.defense -= 20;
    }

}
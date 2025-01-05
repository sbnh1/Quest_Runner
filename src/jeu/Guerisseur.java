package jeu;

import visiteur.VisiteurPerso;

public class Guerisseur extends Personnage {
    private int sagesse;

    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = 10;
    }

    @Override
    public void accept(VisiteurPerso v) {
        v.visite(this);
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

    public int getPointDeVieDeBase(){
        return maxPointDeVie;
    }

    public void augmenterLvl(){
        this.sagesse += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterSoin(15);
        this.getArme().augmenterDegat(5);
    }

    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

    public void diminuerDegat(){
        arme.augmenterDegat(-5);
    }

    public void augmenterDefense(){
        this.defense += 10;
    }

    public void diminuerDefense(){
        this.defense -= 10;
    }
}

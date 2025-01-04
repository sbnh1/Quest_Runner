package jeu;

import visiteur.VisiteurPerso;

public class Sorcier extends Personnage {
    private int intelligence;

    public Sorcier(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.intelligence = 10;
    }

    public Sorcier(int pointDevie, int niveau, String nom, Arme arme, int intelligence){
        super(pointDevie,niveau,nom,arme);
        this.intelligence = intelligence;
    }

    @Override
    public void accept(VisiteurPerso v) {
        v.visite(this);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void augmenterLvl(){
        this.intelligence += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
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
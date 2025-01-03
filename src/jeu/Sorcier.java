package jeu;

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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void augmenterLvl(){
        this.intelligence += 3;
        this.pointsDeVie += 10;
        this.pointDeVieDeBase += 10;
        this.niveau += 1;
    }

    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

}
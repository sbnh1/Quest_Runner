package jeu;

import visiteur.VisiteurPerso;

public class Sorcier extends Personnage {
    private int intelligence;

    /**
     * Constructeur de la classe Sorcier
     * @param pointsDeVie Points de vie
     * @param niveau Niveau
     * @param nom Nom
     * @param arme Arme
     */
    public Sorcier(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.intelligence = 10;
    }

    /**
     * Constructeur de la classe Sorcier
     * @param pointDevie Points de vie
     * @param niveau Niveau
     * @param nom Nom
     * @param arme Arme
     * @param intelligence Intelligence
     */
    public Sorcier(int pointDevie, int niveau, String nom, Arme arme, int intelligence){
        super(pointDevie,niveau,nom,arme);
        this.intelligence = intelligence;
    }

    /**
     * Méthode pour accepter un visiteur
     * @param v Visiteur
     */
    @Override
    public void accept(VisiteurPerso v) {
        v.visite(this);
    }

    /**
     * Méthode pour récupérer l'intelligence du sorcier
     * @return intelligence Intelligence du sorcier
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Méthode pour modifier l'intelligence du sorcier
     * @param intelligence Intelligence du sorcier
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Méthode pour augmenter le niveau du sorcier
     */
    public void augmenterLvl(){
        this.intelligence += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterSoin(5);
        this.getArme().augmenterDegat(7);
    }

    /**
     * Méthode pour augmenter les dégats de l'arme du sorcier
     */
    public void augmenterDegat(){
        arme.augmenterDegat(15);
    }

    /**
     * Méthode pour diminuer les dégats de l'arme du sorcier
     */
    public void diminuerDegat(){
        arme.augmenterDegat(-15);
    }

    /**
     * Méthode pour augmenter la défense du sorcier
     */
    public void augmenterDefense(){
        this.defense += 10;
    }

    /**
     * Méthode pour diminuer la défense du sorcier
     */
    public void diminuerDefense(){
        this.defense -= 10;
    }

}
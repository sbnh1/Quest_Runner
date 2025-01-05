package jeu;

import visiteur.VisiteurPerso;

public class Guerrier extends Personnage {
    private int force;

    /**
     * Constructeur de la classe Guerisseur
     * @param pointsDeVie
     * @param niveau
     * @param nom
     * @param arme
     */
    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = 10;
    }

    /**
     * Constructeur de la classe Guerisseur
     * @param pointsDeVie
     * @param niveau
     * @param nom
     * @param arme
     * @param force
     */
    public Guerrier(int pointsDeVie, int niveau, String nom, Arme arme, int force) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
    }

    /**
     * Accepter un visiteur
     * @param v Visiteur
     */
    @Override
    public void accept(VisiteurPerso v) {
        v.visite(this);
    }

    /**
     * Retourne la force
     * @return force
     */
    public int getForce() {
        return force;
    }

    /**
     * Définit la force
     * @param force
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Méthode pour augmenter le niveau du personnage
     */
    public void augmenterLvl(){
        this.force += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterDegat(10);
    }

    /**
     * Méthode pour augmenter les dégats de l'arme
     */
    public void augmenterDegat(){
        arme.augmenterDegat(15);
    }

    /**
     * Méthode pour diminuer les dégats de l'arme
     */
    public void diminuerDegat(){
        arme.augmenterDegat(-15);
    }

    /**
     * Méthode pour augmenter la défense du personnage
     */
    public void augmenterDefense(){
        this.defense += 10;
    }

    /**
     * Méthode pour diminuer la défense du personnage
     */
    public void diminuerDefense(){
        this.defense -= 10;
    }
}

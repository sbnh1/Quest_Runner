package jeu;

import visiteur.VisiteurPerso;

public class Guerisseur extends Personnage {
    private int sagesse;

    /**
     * Constructeur de la classe Guerisseur
     * @param pointsDeVie points de vie
     * @param niveau niveau
     * @param nom nom
     * @param arme arme
     */
    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = 10;
    }

    /**
     * Constructeur de la classe Guerisseur
     * @param pointsDeVie points de vie
     * @param niveau niveau
     * @param nom nom
     * @param arme arme
     * @param sagesse sagesse
     */
    public Guerisseur(int pointsDeVie, int niveau, String nom, Arme arme, int sagesse) {
        super(pointsDeVie, niveau, nom, arme);
        this.sagesse = sagesse;
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
     * Retourne la sagesse
     * @return sagesse
     */
    public int getSagesse() {
        return sagesse;
    }

    /**
     * Définit la sagesse
     * @param sagesse
     */
    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }

    /**
     * Méthode pour augmenter le niveau du personnage
     */
    public void augmenterLvl(){
        this.sagesse += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterSoin(15);
        this.getArme().augmenterDegat(5);
    }

    /**
     * Méthode pour augmenter les dégats de l'arme
     */
    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

    /**
     * Méthode pour diminuer les dégats de l'arme
     */
    public void diminuerDegat(){
        arme.augmenterDegat(-5);
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

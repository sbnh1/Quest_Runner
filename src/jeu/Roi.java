package jeu;

import visiteur.VisiteurPerso;

public class Roi extends Personnage {
    private int force;
    private String royaume;

    /**
     * Constructeur de la classe Roi
     * @param pointsDeVie Points de vie du roi
     * @param niveau Niveau du roi
     * @param nom Nom du roi
     * @param arme Arme du roi
     */
    public Roi(int pointsDeVie, int niveau, String nom, Arme arme) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = 10;
        this.royaume = "royaume1";
    }

    /**
     * Constructeur de la classe Roi
     * @param pointsDeVie Points de vie du roi
     * @param niveau Niveau du roi
     * @param nom Nom du roi
     * @param arme Arme du roi
     * @param force Force du roi
     * @param royaume Royaume du roi
     */
    public Roi(int pointsDeVie, int niveau, String nom, Arme arme, int force, String royaume) {
        super(pointsDeVie, niveau, nom, arme);
        this.force = force;
        this.royaume = royaume;
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
     * Méthode pour récupérer la force du roi
     * @return force Force du roi
     */
    public int getForce() {
        return force;
    }

    /**
     * Méthode pour modifier la force du roi
     * @param force Force du roi
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Méthode pour récupérer le royaume du roi
     * @return royaume Royaume du roi
     */
    public String getRoyaume() {
        return royaume;
    }

    /**
     * Méthode pour modifier le royaume du roi
     * @param royaume Royaume du roi
     */
    public void setRoyaume(String royaume) {
        this.royaume = royaume;
    }

    /**
     * Méthode pour augmenter le niveau du roi
     */
    public void augmenterLvl(){
        this.force += 3;
        this.pointsDeVie += 10;
        this.maxPointDeVie += 10;
        this.niveau += 1;
        this.defense += 5;
        this.getArme().augmenterSoin(2);
        this.getArme().augmenterDegat(10);
    }

    /**
     * Méthode pour augmenter les dégâts du roi
     */
    public void augmenterDegat(){
        arme.augmenterDegat(5);
    }

    /**
     * Méthode pour diminuer les dégâts du roi
     */
    public void diminuerDegat(){
        arme.augmenterDegat(-5);
    }

    /**
     * Méthode pour augmenter la défense du roi
     */
    public void augmenterDefense(){
        this.defense += 20;
    }

    /**
     * Méthode pour diminuer la défense du roi
     */
    public void diminuerDefense(){
        this.defense -= 20;
    }

}
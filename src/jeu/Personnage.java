package jeu;

import composite.InterfaceEquipe;
import etat.*;
import strategie.*;
import visiteur.*;

public abstract class Personnage implements InterfaceEquipe {
    protected int pointsDeVie;
    protected int maxPointDeVie;
    protected int niveau;
    protected String nom;
    protected Arme arme;
    protected int defense;
    protected int Nbstrategie;

    protected Strategie strategie;
    protected Etat etat;

    /**
     * Constructeur de la classe Personnage
     * @param pointsDeVie Points de vie du personnage
     * @param niveau Niveau du personnage
     * @param nom Nom du personnage
     * @param arme Arme du personnage
     */
    public Personnage(int pointsDeVie, int niveau, String nom, Arme arme){
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
        this.arme = arme;
        this.maxPointDeVie = pointsDeVie;
        this.defense = 10;
        this.Nbstrategie = 0; // 0 = normal, 1 = attaque, 2 = defense
        this.strategie = new ModeNormal();
        this.etat = new EtatVivant();
    }

    /**
     * Méthode pour récupérer les points de vie du personnage
     * @return pointsDeVie Points de vie du personnage
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Méthode pour modifier les points de vie du personnage
     * @param pointsDeVie Points de vie du personnage
     */
    public void setPointsDeVie(int pointsDeVie) {
        if(pointsDeVie > maxPointDeVie){
            this.pointsDeVie = maxPointDeVie;
        } else if(pointsDeVie < 0){
            this.pointsDeVie = 0;
        } else {
            this.pointsDeVie = pointsDeVie;
        }
        updateEtat();
    }

    /**
     * Méthode pour récupérer l'état du personnage
     * @return etat Etat du personnage
     */
    public void updateEtat(){
        if(pointsDeVie == 0){
            System.out.println(nom + " est mort.");
            etat = new EtatMort();
        } else if(pointsDeVie < maxPointDeVie / 4){
            System.out.println(nom + " est blessé.");
            etat = new EtatBlesse();
        } else {
            System.out.println(nom + " est en forme.");
            etat = new EtatVivant();
        }
    }

    /**
     * Méthode pour récupérer les points de vie maximum du personnage
     * @return maxPointDeVie Points de vie maximum du personnage
     */
    public int getMaxPointsDeVie() {
        return maxPointDeVie;
    }

    /**
     * Méthode pour modifier les points de vie maximum du personnage
     * @param pdv Points de vie maximum du personnage
     */
    public void setMaxPointDeVie(int pdv){
        this.maxPointDeVie += pdv;
    }

    /**
     * Méthode pour augmenter le niveau du personnage
     */
    public abstract void augmenterLvl();

    /**
     * Méthode pour récupérer le niveau du personnage
     * @return niveau Niveau du personnage
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Méthode pour modifier le niveau du personnage
     * @param niveau Niveau du personnage
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * Méthode pour récupérer le nom du personnage
     * @return nom Nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour modifier le nom du personnage
     * @param nom Nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour récupérer l'arme du personnage
     * @return arme Arme du personnage
     */
    public Arme getArme() {
        return arme;
    }

    /**
     * Méthode pour modifier l'arme du personnage
     * @param arme Arme du personnage
     */
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    /**
     * Méthode pour récupérer la défense du personnage
     * @return defense Défense du personnage
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Méthode pour modifier la défense du personnage
     * @param defense Défense du personnage
     */
    public int setDefense(int defense) {
        return this.defense = defense;
    }

    /**
     * Méthode pour augmenter les dégâts du personnage
     */
    public abstract void augmenterDegat();

    /**
     * Méthode pour diminuer les dégâts du personnage
     */
    public abstract void diminuerDegat();

    /**
     * Méthode pour augmenter la défense du personnage
     */
    public abstract void augmenterDefense();

    /**
     * Méthode pour diminuer la défense du personnage
     */
    public abstract void diminuerDefense();

    /**
     * Méthode pour accepter un visiteur
     * @param v Visiteur
     */
    public abstract void accept(VisiteurPerso v);

    /**
     * Méthode pour récupérer la stratégie de combat du personnage
     * @return strategie Stratégie de combat du personnage
     */
    public int getStrategie() {
        return Nbstrategie;
    }

    /**
     * Méthode pour modifier la stratégie de combat du personnage
     * @param strategie Stratégie de combat du personnage
     */
    public void setStrategie(int strategie) {
        this.Nbstrategie = strategie;
    }

    /**
     * Méthode pour choisir la stratégie de combat normal du personnage
     */
    public void choisirModeNormal() {
        strategie = new ModeNormal();
        strategie.choisirStrategieDeCombat(this);
    }

    /**
     * Méthode pour choisir la stratégie de combat attaque du personnage
     */
    public void choisirModeAttaque() {
        strategie = new ModeAttaque();
        strategie.choisirStrategieDeCombat(this);
    }

    /**
     * Méthode pour choisir la stratégie de combat défense du personnage
     */
    public void choisirModeDefense() {
        strategie = new ModeDefense();
        strategie.choisirStrategieDeCombat(this);
    }

    /**
     * Méthode pour attaquer un personnage
     * @param cible Personnage cible
     */
    public void attaquer(Personnage cible){
        etat.attaquer(this, cible);
    }

    /**
     * Méthode pour soigner un personnage
     * @param cible Personnage cible
     */
    public void soigner(Personnage cible){
        cible.etat.soigner(cible);
    }
}

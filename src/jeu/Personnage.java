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
    public int getPointsDeVie() {
        return pointsDeVie;
    }

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

    public int getMaxPointsDeVie() {
        return maxPointDeVie;
    }

    public void setMaxPointDeVie(int pdv){
        this.maxPointDeVie += pdv;
    }

    public abstract void augmenterLvl();

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public int getDefense() {
        return defense;
    }

    public int setDefense(int defense) {
        return this.defense = defense;
    }

    public abstract void augmenterDegat();

    public abstract void diminuerDegat();

    public abstract void augmenterDefense();

    public abstract void diminuerDefense();

    public abstract void accept(VisiteurPerso v);

    public int getStrategie() {
        return Nbstrategie;
    }

    public void setStrategie(int strategie) {
        this.Nbstrategie = strategie;
    }

    public void choisirModeNormal() {
        strategie = new ModeNormal();
        strategie.choisirStrategieDeCombat(this);
    }

    public void choisirModeAttaque() {
        strategie = new ModeAttaque();
        strategie.choisirStrategieDeCombat(this);
    }

    public void choisirModeDefense() {
        strategie = new ModeDefense();
        strategie.choisirStrategieDeCombat(this);
    }

    public void attaquer(Personnage cible){
        etat.attaquer(this, cible);
    }

    public void soigner(Personnage cible){
        cible.etat.soigner(cible);
    }
}

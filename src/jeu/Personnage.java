package jeu;

import composite.InterfaceEquipe;
import strategie.*;
import visiteur.*;

public abstract class Personnage implements InterfaceEquipe {
    protected int pointsDeVie;
    protected int pointDeVieDeBase;
    protected int niveau;
    protected String nom;
    protected Arme arme;
    protected int defense;
    protected int Nbstrategie;

    protected Strategie strategie;

    public Personnage(int pointsDeVie, int niveau, String nom, Arme arme){
        this.pointsDeVie = pointsDeVie;
        this.niveau = niveau;
        this.nom = nom;
        this.arme = arme;
        this.pointDeVieDeBase = pointsDeVie;
        this.defense = 10;
        this.Nbstrategie = 0; // 0 = normal, 1 = attaque, 2 = defense
        this.strategie = new ModeNormal();
    }
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

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
}

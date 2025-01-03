package jeu;

import org.junit.jupiter.api.Test;
import jeu.*;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class GuerisseurTest {

    @Test
    void augmenterLvl() {
        Personnage guerrisseur = new Guerisseur(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        guerrisseur.accept(new NiveauVisiteur());
        assertEquals(2,guerrisseur.getNiveau());
    }

    @Test
    void augmenterDegat() {
        Personnage guerrisseur = new Guerisseur(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        guerrisseur.accept(new DegatVisiteur());
        assertEquals(15,guerrisseur.getArme().getDegat());
    }

    @Test
    void modeAttaque(){
        Personnage guerrisseur = new Guerisseur(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        guerrisseur.choisirModeAttaque();
        assertEquals(0,guerrisseur.getDefense());
        assertEquals(15,guerrisseur.getArme().getDegat());
    }

    @Test
    void modeDefense(){
        Personnage guerrisseur = new Guerisseur(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        guerrisseur.choisirModeDefense();
        assertEquals(20,guerrisseur.getDefense());
        assertEquals(5,guerrisseur.getArme().getDegat());
    }

    @Test
    void modeNormal(){
        Personnage guerrisseur = new Guerisseur(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        guerrisseur.choisirModeDefense();
        guerrisseur.choisirModeNormal();
        assertEquals(10,guerrisseur.getDefense());
    }
}
package jeu;

import org.junit.jupiter.api.Test;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class SorcierTest {

    @Test
    void augmenterLvl() {
        Personnage personnage = new Sorcier(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.accept(new NiveauVisiteur());
        assertEquals(2,personnage.getNiveau());
    }

    @Test
    void augmenterDegat() {
        Personnage personnage = new Sorcier(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.accept(new DegatVisiteur());
        assertEquals(25,personnage.getArme().getDegat());
    }

    @Test
    void modeAttaque(){
        Personnage personnage = new Sorcier(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeAttaque();
        assertEquals(0,personnage.getDefense());
        assertEquals(25,personnage.getArme().getDegat());
    }

    @Test
    void modeDefense(){
        Personnage personnage = new Sorcier(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeDefense();
        assertEquals(20,personnage.getDefense());
        assertEquals(-5,personnage.getArme().getDegat());
    }

    @Test
    void modeNormal(){
        Personnage personnage = new Sorcier(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeDefense();
        personnage.choisirModeNormal();
        assertEquals(10,personnage.getDefense());
    }
}
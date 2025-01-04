package jeu;

import org.junit.jupiter.api.Test;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class RoiTest {

    @Test
    void augmenterLvl() {
        Personnage personnage = new Roi(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.accept(new NiveauVisiteur());
        assertEquals(2,personnage.getNiveau());
    }

    @Test
    void augmenterDegat() {
        Personnage personnage = new Roi(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.accept(new DegatVisiteur());
        assertEquals(15,personnage.getArme().getDegat());
    }

    @Test
    void modeAttaque(){
        Personnage personnage = new Roi(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeAttaque();
        assertEquals(-10,personnage.getDefense());
        assertEquals(15,personnage.getArme().getDegat());
    }

    @Test
    void modeDefense(){
        Personnage personnage = new Roi(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeDefense();
        assertEquals(30,personnage.getDefense());
        assertEquals(5,personnage.getArme().getDegat());
    }

    @Test
    void modeNormal(){
        Personnage personnage = new Roi(10,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        personnage.choisirModeDefense();
        personnage.choisirModeNormal();
        assertEquals(10,personnage.getDefense());
    }

    @Test
    void transitionVivantBlesseMort(){
        Personnage personnage = new Roi(12,1,"eniripsia",new BaguetteMagique("baguette",10,3.));
        Personnage attaquant = new Roi(10,1,"attaquant",new BaguetteMagique("baguette",10,3.));
        attaquant.etat.attaquer(attaquant,personnage);
        assertEquals(2,personnage.getPointsDeVie());
        attaquant.etat.attaquer(attaquant,personnage);
        assertEquals(0,personnage.getPointsDeVie());
    }
}
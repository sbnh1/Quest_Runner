package jeu;

import org.junit.jupiter.api.Test;
import visiteur.DegatVisiteur;
import visiteur.NiveauVisiteur;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    @Test
    void augmenterLvl() {
        Personnage guerrier = new Guerrier(10,1,"iop",new Epee("Mashwarr", 10,1.));
        guerrier.accept(new NiveauVisiteur());
        assertEquals(2, guerrier.getNiveau());
    }

    @Test
    void augmenterDegat() {
        Personnage guerrier = new Guerrier(10,1,"iop",new Epee("Mashwarr", 10,1.));
        guerrier.accept(new DegatVisiteur());
        assertEquals(25, guerrier.getArme().getDegat());
    }

    @Test
    void modeAttaque(){
        Personnage guerrier = new Guerrier(10,1,"iop",new Epee("Mashwarr", 10,1.));
        guerrier.choisirModeAttaque();
        assertEquals(0, guerrier.getDefense());
        assertEquals(25, guerrier.getArme().getDegat());
    }

    @Test
    void modeDefense(){
        Personnage guerrier = new Guerrier(10,1,"iop",new Epee("Mashwarr", 10,1.));
        guerrier.choisirModeDefense();
        assertEquals(20, guerrier.getDefense());
        assertEquals(-5, guerrier.getArme().getDegat());
    }

    @Test
    void modeNormal(){
        Personnage guerrier = new Guerrier(10,1,"iop",new Epee("Mashwarr", 10,1.));
        guerrier.choisirModeDefense();
        guerrier.choisirModeNormal();
        assertEquals(10, guerrier.getDefense());
    }

    // Test des transitions (Vivant -> Blessé -> Mort)
    @Test
    void transitionVivantBlesseMort() {
        Personnage guerrier = new Guerrier(12, 1, "iop", new Epee("Mashwarr", 10, 1.));
        Personnage attaquant = new Guerrier(10, 1, "attaquant", new BaguetteMagique("baguette", 10, 3.));
        attaquant.etat.attaquer(attaquant, guerrier);
        assertEquals(2, guerrier.getPointsDeVie());
        attaquant.etat.attaquer(attaquant, guerrier);
        assertEquals(0, guerrier.getPointsDeVie());
    }
}
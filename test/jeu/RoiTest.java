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
}
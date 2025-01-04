package etat;

import jeu.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtatMortTest {

    @Test
    void attaquer() {
        EtatMort etatMort = new EtatMort();
        Personnage attaquant = new Roi(0, 1, "attaquant", new BaguetteMagique("baguette", 30, 3.));
        Personnage cible = new Roi(10, 1, "cible", new BaguetteMagique("baguette", 10, 3.));
        attaquant.updateEtat();
        attaquant.attaquer(cible);
        assertEquals(0, attaquant.getPointsDeVie());
    }

    @Test
    void soigner() {
        EtatMort etatMort = new EtatMort();
        Personnage attaquant = new Roi(10, 1, "attaquant", new BaguetteMagique("baguette", 30, 3.));
        Personnage cible = new Roi(0, 1, "cible", new BaguetteMagique("baguette", 10, 3.));
        cible.updateEtat();
        attaquant.soigner(cible);
        assertEquals(0, cible.getPointsDeVie());
    }
}
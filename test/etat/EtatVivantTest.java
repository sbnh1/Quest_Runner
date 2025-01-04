package etat;

import jeu.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtatVivantTest {

    @Test
    void attaquer() {
        EtatVivant etatVivant = new EtatVivant();
        Personnage attaquant = new Roi(10, 1, "attaquant", new BaguetteMagique("baguette", 3, 3.));
        Personnage cible = new Roi(10, 1, "cible", new BaguetteMagique("baguette", 10, 3.));
        etatVivant.attaquer(attaquant, cible);
        assertEquals(7, cible.getPointsDeVie());
    }

    @Test
    void soigner() {
        EtatVivant etatVivant = new EtatVivant();
        Personnage attaquant = new Roi(10, 1, "attaquant", new BaguetteMagique("baguette", 3, 3.));
        Personnage cible = new Roi(10, 1, "cible", new BaguetteMagique("baguette", 10, 3.));
        etatVivant.attaquer(attaquant, cible);
        etatVivant.attaquer(attaquant, cible);
        etatVivant.attaquer(attaquant, cible);
        etatVivant.soigner(cible);
        assertEquals(3, cible.getPointsDeVie());
    }

}
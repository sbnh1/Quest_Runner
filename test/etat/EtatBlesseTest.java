package etat;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.zip.ZipEntry;

import static org.junit.jupiter.api.Assertions.*;

class EtatBlesseTest {

    @Test
    void attaquer() {
        Etat etat = new EtatBlesse();
        Personnage attaquant = new Guerrier(100, 1, "Jean", new Epee("Epée", 10,2));
        Personnage cible = new Guerrier(100, 1, "Paul", new Epee("Epée", 10,2));
        etat.attaquer(attaquant, cible);
        assertEquals(80, cible.getPointsDeVie());
    }

    @Test
    void soigner() {
        Etat etat = new EtatBlesse();
        Personnage attaquant = new Guerrier(100, 1, "Jean", new Epee("Epée", 20,2));
        Personnage cible = new Guerrier(100, 1, "Paul", new Epee("Epée", 10,2));
        etat.attaquer(attaquant, cible);
        etat.attaquer(attaquant, cible);
        etat.soigner(cible);
        assertEquals(45, cible.getPointsDeVie());
    }
}
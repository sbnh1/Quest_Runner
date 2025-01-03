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
        assertEquals(15, guerrier.getArme().getDegat());
    }
}
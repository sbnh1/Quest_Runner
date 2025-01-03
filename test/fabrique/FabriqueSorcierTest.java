package fabrique;

import jeu.Personnage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FabriqueSorcierTest {

    @Test
    void creerPersonnage0(){
        Personnage sorcier = new FabriqueSorcier().creerPersonnage();
        assertNotNull(new FabriqueSorcier().creerPersonnage());
    }


    @Test
    void creerPersonnage() {
        FabriqueSorcier fabriqueSorcier = new FabriqueSorcier();
        assertEquals("sorcier", fabriqueSorcier.creerPersonnage().getNom());
    }

    @Test
    void creerPersonnage1() {
        FabriqueSorcier fabriqueSorcier = new FabriqueSorcier();
        assertEquals(10, fabriqueSorcier.creerPersonnage().getDefense());
    }

    @Test
    void creerPersonnage2() {
        FabriqueSorcier fabriqueSorcier = new FabriqueSorcier();
        assertEquals(20, fabriqueSorcier.creerPersonnage().getPointsDeVie());
    }

    @Test
    void creerPersonnage3() {
        FabriqueSorcier fabriqueSorcier = new FabriqueSorcier();
        assertEquals(1, fabriqueSorcier.creerPersonnage().getNiveau());
    }
}
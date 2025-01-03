package fabrique;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueGuerrierTest {

    @Test
    void creerPersonnage() {
        FabriqueGuerrier fabriqueGuerrier = new FabriqueGuerrier();
        assertNotNull(fabriqueGuerrier.creerPersonnage());
    }

    @Test
    void creerPersonnageNotNull() {
        FabriqueGuerrier fabriqueGuerrier = new FabriqueGuerrier();
        assertNotNull(fabriqueGuerrier.creerPersonnage());
    }

    @Test
    void creerPersonnageIsGuerrier() {
        FabriqueGuerrier fabriqueGuerrier = new FabriqueGuerrier();
        assertEquals("guerrier", fabriqueGuerrier.creerPersonnage().getNom());
    }

    @Test
    void creerPersonnageIsGuerrierNotNull() {
        FabriqueGuerrier fabriqueGuerrier = new FabriqueGuerrier();
        assertNotNull(fabriqueGuerrier.creerPersonnage().getNom());
    }

    @Test
    void creerPersonnageIsGuerrierNotNull2() {
        FabriqueGuerrier fabriqueGuerrier = new FabriqueGuerrier();
        assertNotNull(fabriqueGuerrier.creerPersonnage().getNom());
    }
}
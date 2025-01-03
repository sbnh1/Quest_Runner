package fabrique;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueGuerisseurTest {

    @Test
    void creerPersonnage() {
        FabriqueGuerisseur fabriqueGuerisseur = new FabriqueGuerisseur();
        assertNotNull(fabriqueGuerisseur.creerPersonnage());
    }

    @Test
    void creerPersonnage2() {
        FabriqueGuerisseur fabriqueGuerisseur = new FabriqueGuerisseur();
        assertEquals("guerisseur", fabriqueGuerisseur.creerPersonnage().getNom());
    }

    @Test
    void creerPersonnage3() {
        FabriqueGuerisseur fabriqueGuerisseur = new FabriqueGuerisseur();
        assertEquals(20, fabriqueGuerisseur.creerPersonnage().getPointsDeVie());
    }

    @Test
    void creerPersonnage4() {
        FabriqueGuerisseur fabriqueGuerisseur = new FabriqueGuerisseur();
        assertEquals(1, fabriqueGuerisseur.creerPersonnage().getNiveau());
    }

    @Test
    void creerPersonnage5() {
        FabriqueGuerisseur fabriqueGuerisseur = new FabriqueGuerisseur();
        assertEquals("baton du guerisseur", fabriqueGuerisseur.creerPersonnage().getArme().getNom());
    }
}
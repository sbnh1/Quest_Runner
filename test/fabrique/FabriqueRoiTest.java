package fabrique;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueRoiTest {

    @Test
    void creerPersonnage() {
        FabriqueRoi fabriqueRoi = new FabriqueRoi();
        assertNotNull(fabriqueRoi.creerPersonnage());
    }

    @Test
    void testCreerPersonnage() {
        FabriqueRoi fabriqueRoi = new FabriqueRoi();
        assertEquals("roi", fabriqueRoi.creerPersonnage().getNom());
    }

    @Test
    void testCreerPersonnage2() {
        FabriqueRoi fabriqueRoi = new FabriqueRoi();
        assertEquals(30, fabriqueRoi.creerPersonnage().getPointsDeVie());
    }

    @Test
    void testCreerPersonnage3() {
        FabriqueRoi fabriqueRoi = new FabriqueRoi();
        assertEquals(1, fabriqueRoi.creerPersonnage().getNiveau());
    }

    @Test
    void testCreerPersonnage4() {
        FabriqueRoi fabriqueRoi = new FabriqueRoi();
        assertEquals("epee du roi", fabriqueRoi.creerPersonnage().getArme().getNom());
    }
}
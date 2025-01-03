package singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteurDeTourTest {

    @BeforeEach
    public void resetCompteur() {
        CompteurDeTour.getInstance().reset();
    }

    @Test
    public void testInitialCompteur() {
        CompteurDeTour compteur = CompteurDeTour.getInstance();
        assertEquals(0, compteur.getCompteur());
    }

    @Test
    public void testAjouterUnTour() {
        CompteurDeTour compteur = CompteurDeTour.getInstance();
        compteur.ajouterUnTour();
        assertEquals(1, compteur.getCompteur());
        compteur.ajouterUnTour();
        assertEquals(2, compteur.getCompteur());
    }

    @Test
    public void testResetCompteur() {
        CompteurDeTour compteur = CompteurDeTour.getInstance();
        compteur.ajouterUnTour();
        compteur.ajouterUnTour();
        compteur.reset();
        assertEquals(0, compteur.getCompteur());
    }
}
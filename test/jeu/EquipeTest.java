package jeu;

import jeu.*;
import composite.InterfaceEquipe;
import visiteur.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipeTest {

    @Test
    void ajouter() {
        Personnage roi = new Roi(10,1,"personnage",new Epee("excalibur",5,3));
        Equipe equipe = new Equipe();
        equipe.ajouter(roi);
        assertEquals(1,equipe.getSize());
    }

    @Test
    void supprimer() {
        Personnage roi = new Roi(10,1,"personnage",new Epee("excalibur",5,3));
        Personnage guerrier = new Guerrier(10,1,"personnage",new Epee("excalibur",5,3));
        Equipe equipe = new Equipe();
        equipe.ajouter(roi);
        equipe.ajouter(guerrier);
        equipe.supprimer(roi);
        assertEquals(1,equipe.getSize());
    }

    @Test
    void getSize() {
        Personnage roi = new Roi(10,1,"personnage",new Epee("excalibur",5,3));
        Personnage guerrier = new Guerrier(10,1,"personnage",new Epee("excalibur",5,3));

        Equipe equipe = new Equipe();
        equipe.ajouter(roi);

        Equipe equipe2 = new Equipe();
        equipe2.ajouter(guerrier);
        equipe2.ajouter(equipe);

        assertEquals(2,equipe2.getSize());
    }

}
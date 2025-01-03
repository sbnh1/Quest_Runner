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

    @Test
    void Equipe0Sorcier(){
        Personnage roi = new Roi(10,1,"personnage",new Epee("excalibur",5,3));
        Personnage guerrier = new Guerrier(10,1,"personnage",new Epee("excalibur",5,3));

        Equipe equipe = new Equipe();
        equipe.ajouter(roi);
        equipe.ajouter(guerrier);

        NombreSorcierVisiteur nbSorcier = new NombreSorcierVisiteur();
        equipe.accept(nbSorcier);

        assertEquals(0,nbSorcier.getNbSorcier());
    }

    @Test
    void EquipeSorcier(){
        Personnage roi = new Roi(10,1,"personnage",new Epee("excalibur",5,3));
        Personnage guerrier = new Guerrier(10,1,"personnage",new Epee("excalibur",5,3));
        Personnage sorcier = new Sorcier(10,1,"personnage",new Epee("excalibur",5,3));

        Equipe equipe = new Equipe();
        equipe.ajouter(roi);
        equipe.ajouter(guerrier);
        equipe.ajouter(sorcier);

        NombreSorcierVisiteur nbSorcier = new NombreSorcierVisiteur();
        equipe.accept(nbSorcier);

        assertEquals(1,nbSorcier.getNbSorcier());
    }
}
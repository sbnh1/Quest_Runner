package visiteur;

import jeu.Guerisseur;
import jeu.Guerrier;
import jeu.Roi;
import jeu.Sorcier;

public class NiveauVisiteur implements VisiteurPerso{
    @Override
    public void visite(Guerrier guerrier){
        guerrier.augmenterLvl();
    }

    @Override
    public void visite(Guerisseur guerisseur){
        guerisseur.augmenterLvl();
    }

    @Override
    public void visite(Roi roi){
        roi.augmenterLvl();
    }

    @Override
    public void visite(Sorcier sorcier){
        sorcier.augmenterLvl();
    }
}

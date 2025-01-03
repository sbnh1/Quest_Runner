package visiteur;

import jeu.*;

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

    @Override
    public void visite(Equipe equipe) {
        for (int i = 0; i < equipe.getSize(); i++) {
            equipe.getChild(i).accept(this);
        }
    }
}

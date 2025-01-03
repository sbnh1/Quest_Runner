package visiteur;

import jeu.*;

public class NombreSorcierVisiteur implements VisiteurPerso{
    private int nbSorcier = 0;

    @Override
    public void visite(Roi roi) {

    }

    @Override
    public void visite(Guerrier guerrier) {

    }

    @Override
    public void visite(Guerisseur guerrisseur) {

    }

    @Override
    public void visite(Sorcier sorcier) {
        nbSorcier++;
    }

    @Override
    public void visite(Equipe equipe) {
        for (int i = 0; i < equipe.getSize(); i++) {
            equipe.getChild(i).accept(this);
        }
    }

    public int getNbSorcier(){
        return nbSorcier;
    }
}

package visiteur;

import jeu.*;

public class NiveauVisiteur implements VisiteurPerso{
    /**
     * Méthode pour visiter un personnage de type Guerrier
     * @param guerrier Guerrier
     */
    @Override
    public void visite(Guerrier guerrier){
        guerrier.augmenterLvl();
    }

    /**
     * Méthode pour visiter un personnage de type Guerisseur
     * @param guerisseur Guerisseur
     */
    @Override
    public void visite(Guerisseur guerisseur){
        guerisseur.augmenterLvl();
    }

    /**
     * Méthode pour visiter un personnage de type Roi
     * @param roi Roi
     */
    @Override
    public void visite(Roi roi){
        roi.augmenterLvl();
    }

    /**
     * Méthode pour visiter un personnage de type Sorcier
     * @param sorcier Sorcier
     */
    @Override
    public void visite(Sorcier sorcier){
        sorcier.augmenterLvl();
    }

    /**
     * Méthode pour visiter une équipe
     * @param equipe Equipe
     */
    @Override
    public void visite(Equipe equipe) {
        for (int i = 0; i < equipe.getSize(); i++) {
            equipe.getChild(i).accept(this);
        }
    }
}

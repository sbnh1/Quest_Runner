package visiteur;

import jeu.*;

public class NombreSorcierVisiteur implements VisiteurPerso{
    private int nbSorcier = 0;

    /**
     * Méthode pour visiter un personnage de type Roi
     * @param roi Roi
     */
    @Override
    public void visite(Roi roi) {

    }

    /**
     * Méthode pour visiter un personnage de type Guerrier
     * @param guerrier Guerrier
     */
    @Override
    public void visite(Guerrier guerrier) {

    }

    /**
     * Méthode pour visiter un personnage de type Guerisseur
     * @param guerisseur Guerisseur
     */
    @Override
    public void visite(Guerisseur guerisseur) {

    }

    /**
     * Méthode pour visiter un personnage de type Sorcier
     * @param sorcier Sorcier
     */
    @Override
    public void visite(Sorcier sorcier) {
        nbSorcier++;
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

    /**
     * Méthode pour obtenir le nombre de sorciers
     * @return int Nombre de sorciers   
     */
    public int getNbSorcier(){
        return nbSorcier;
    }
}

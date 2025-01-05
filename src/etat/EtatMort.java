package etat;

import jeu.Personnage;

public class EtatMort implements Etat{

    /**
     * Attaque un personnage
     * @param attaquant le personnage attaquant
     * @param cible le personnage cible
     */
    @Override
    public void attaquer(Personnage attaquant, Personnage cible) {
        System.out.println(attaquant.getNom() + " est mort et ne peut pas attaquer");
    }

    /**
     * Soigne un personnage
     * @param personnage le personnage à soigner
     */
    @Override
    public void soigner(Personnage personnage) {
        System.out.println(personnage.getNom() + " est mort et ne peut pas être soigné");
    }
}

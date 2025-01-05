package etat;

import jeu.Personnage;

public class EtatBlesse implements Etat {

    /**
     * Attaque un personnage
     * @param attaquant le personnage attaquant
     * @param cible le personnage cible
     */
    @Override
    public void attaquer(Personnage attaquant, Personnage cible) {
        System.out.println(attaquant.getNom() + " attaque " + cible.getNom());
        cible.setPointsDeVie((int)(cible.getPointsDeVie() - attaquant.getArme().getDegat() * 2)); // on frappe plus fort quand on est au bord de la mort
        System.out.println(cible.getNom() + " a maintenant " + cible.getPointsDeVie() + " points de vie");
    }

    /**
     * Soigne un personnage
     * @param personnage le personnage à soigner
     */
    @Override
    public void soigner(Personnage personnage) {
        int soin = (personnage.getMaxPointsDeVie() / 4) + personnage.getArme().getSoin();
        personnage.setPointsDeVie(personnage.getPointsDeVie() + soin);
        System.out.println(personnage.getNom() + " est soigné, points de vie actuels : " + personnage.getPointsDeVie());
    }
}

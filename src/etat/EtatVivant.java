package etat;

import jeu.Personnage;


public class EtatVivant implements Etat {

    @Override
    public void attaquer(Personnage attaquant, Personnage cible) {
        System.out.println(attaquant.getNom() + " attaque " + cible.getNom());
        cible.setPointsDeVie(cible.getPointsDeVie() - attaquant.getArme().getDegat());
        System.out.println(cible.getNom() + " a maintenant " + cible.getPointsDeVie() + " points de vie");
    }

    @Override
    public void soigner(Personnage personnage) {
        int soin = personnage.getMaxPointsDeVie() / 5;
        personnage.setPointsDeVie(personnage.getPointsDeVie() + soin);
        System.out.println(personnage.getNom() + " est soigné, points de vie actuels : " + personnage.getPointsDeVie());
    }
}

package etat;

import jeu.Personnage;

public class EtatMort implements Etat{
    @Override
    public void attaquer(Personnage attanquant, Personnage cible) {
        System.out.println(attanquant.getNom() + " est mort et ne peut pas attaquer");
    }

    @Override
    public void soigner(Personnage personnage) {
        System.out.println(personnage.getNom() + " est mort et ne peut pas être soigné");
    }
}

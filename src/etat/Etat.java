package etat;

import jeu.*;

public interface Etat {
    void attaquer(Personnage attanquant, Personnage cible);

    void soigner(Personnage personnage);

}

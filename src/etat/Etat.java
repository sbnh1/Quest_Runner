package etat;

import jeu.*;

public interface Etat {

    /**
     * Attaque un personnage
     * @param attaquant le personnage attaquant
     * @param cible le personnage cible
     */
    void attaquer(Personnage attaquant, Personnage cible);

    /**
     * Soigne un personnage
     * @param personnage le personnage à soigner
     */
    void soigner(Personnage personnage);


}

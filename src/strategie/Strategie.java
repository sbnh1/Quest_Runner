package strategie;

import jeu.Personnage;

public interface Strategie {

    /**
     * Méthode pour choisir la stratégie de combat
     * @param personnage Personnage
     */
    void choisirStrategieDeCombat(Personnage personnage);
}

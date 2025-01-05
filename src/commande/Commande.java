package commande;

import jeu.Personnage;

public interface Commande {

    /**
     * Permet d'executer une commande
     */
    void executer();

    /**
     * Permet de defaire une commande
     */
    void defaire();
}

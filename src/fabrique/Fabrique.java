package fabrique;

import jeu.Personnage;

public abstract class Fabrique {

    /**
     * Constructeur de la classe Fabrique
     */
    public Fabrique(){}

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage
     */
    public abstract Personnage creerPersonnage();
}

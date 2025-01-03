package fabrique;

import jeu.Personnage;

public abstract class Fabrique {
    public Fabrique(){}

    public abstract Personnage creerPersonnage();
}

package fabrique;

import jeu.*;

public class FabriqueGuerrier extends Fabrique {
    /**
     * Constructeur de la classe FabriqueGuerrier
     */
    public FabriqueGuerrier() {
        super();
    }

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage guerrier
     */
    public Personnage creerPersonnage() {
        Arme arme = new Epee("epee du guerrier", 10, 10);
        return new Guerrier(25, 1, "guerrier", arme);
    }
}

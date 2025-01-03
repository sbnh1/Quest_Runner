package fabrique;

import jeu.*;

public class FabriqueGuerrier extends Fabrique {
    public FabriqueGuerrier() {
        super();
    }

    public Personnage creerPersonnage() {
        Arme arme = new Epee("epee du guerrier", 10, 10);
        return new Guerrier(25, 1, "guerrier", arme);
    }
}

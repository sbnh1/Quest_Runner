package fabrique;

import jeu.*;

public class FabriqueRoi extends Fabrique {
    public FabriqueRoi() {
        super();
    }

    public Personnage creerPersonnage() {
        Arme arme = new Epee("epee du roi", 10, 10);
        return new Roi(30, 1, "roi", arme);
    }
}

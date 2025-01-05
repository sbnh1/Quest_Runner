package fabrique;

import jeu.*;

public class FabriqueRoi extends Fabrique {
    /**
     * Constructeur de la classe FabriqueRoi
     */
    public FabriqueRoi() {
        super();
    }

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage roi
     */
    public Personnage creerPersonnage() {
        Arme arme = new Epee("epee du roi", 10, 10);
        return new Roi(30, 1, "roi", arme);
    }
}

package fabrique;

import jeu.*;

public class FabriqueGuerisseur extends Fabrique{

    /**
     * Constructeur de la classe FabriqueGuerisseur
     */
    public FabriqueGuerisseur(){
        super();
    }

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage guerisseur
     */
    public Personnage creerPersonnage(){
        Arme arme = new BaguetteMagique("baton du guerisseur", 10, 10);
        return new Guerisseur(20,1,"guerisseur", arme);
    }
}

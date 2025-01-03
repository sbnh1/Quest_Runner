package fabrique;

import jeu.*;

public class FabriqueGuerisseur extends Fabrique{
    public FabriqueGuerisseur(){
        super();
    }

    public Personnage creerPersonnage(){
        Arme arme = new BaguetteMagique("baton du guerisseur", 10, 10);
        return new Guerisseur(20,1,"guerisseur", arme);
    }
}

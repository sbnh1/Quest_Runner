package fabrique;

import jeu.*;

public class FabriqueSorcier extends Fabrique{
    public FabriqueSorcier(){
        super();
    }

    public Personnage creerPersonnage(){
        Arme arme = new BatonDeSorcier("baton du sorcier", 10, 10);
        return new Sorcier(20,1,"sorcier", arme);
    }
}

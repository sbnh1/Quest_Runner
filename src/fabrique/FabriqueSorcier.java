package fabrique;

import jeu.*;

public class FabriqueSorcier extends Fabrique{
    /**
     * Constructeur de la classe FabriqueSorcier
     */
    public FabriqueSorcier(){
        super();
    }

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage sorcier
     */
    public Personnage creerPersonnage(){
        Arme arme = new BatonDeSorcier("baton du sorcier", 10, 10);
        return new Sorcier(20,1,"sorcier", arme);
    }
}

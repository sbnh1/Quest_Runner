package fabrique;

import composite.InterfaceEquipe;
import jeu.*;

public class FabriqueEquipe extends Fabrique{

    /**
     * Constructeur de la classe FabriqueEquipe
     */
    public FabriqueEquipe(){
        super();
    }

    /**
     * Méthode permettant de créer un personnage
     * @return Personnage
     */
    public Personnage creerPersonnage(){
        return null;
    }

    /**
     * Méthode permettant de créer une équipe
     * @return InterfaceEquipe
     */
    public InterfaceEquipe creerEquipe(){
        int choix = (int)(Math.random()*5);
        switch(choix) {
            case 0:
                Personnage g1 = new Guerrier(25, 1, "guerrier", new Epee("epee du guerrier", 10, 10));
                Personnage g2 = new Roi(30, 1, "guerrier", new Epee("epee du guerrier", 10, 10));
                Equipe equipe1 = new Equipe();
                equipe1.ajouter(g1);
                equipe1.ajouter(g2);
                return equipe1;
            case 1:
                Personnage g3 = new Guerrier(25, 1, "guerrier", new Epee("epee du guerrier", 10, 10));
                Personnage g4 = new Guerisseur(20, 1, "guerisseur", new BaguetteMagique("baton du guerisseur", 10, 10));
                Equipe equipe2 = new Equipe();
                equipe2.ajouter(g3);
                equipe2.ajouter(g4);
                return equipe2;
            case 2:
                Personnage g5 = new Guerrier(25, 1, "guerrier", new Epee("epee du guerrier", 10, 10));
                Personnage g6 = new Sorcier(20, 1, "mage", new BaguetteMagique("baton du mage", 10, 10));
                Equipe equipe3 = new Equipe();
                equipe3.ajouter(g5);
                equipe3.ajouter(g6);
                return equipe3;
            case 3:
                Personnage g7 = new Roi(30, 1, "roi", new Epee("epee du roi", 10, 10));
                Personnage g8 = new Guerisseur(20, 1, "guerisseur", new BaguetteMagique("baton du guerisseur", 10, 10));
                Equipe equipe4 = new Equipe();
                equipe4.ajouter(g7);
                equipe4.ajouter(g8);
                return equipe4;
            case 4:
                Personnage g9 = new Roi(30, 1, "roi", new Epee("epee du roi", 10, 10));
                Personnage g10 = new Sorcier(20, 1, "mage", new BaguetteMagique("baton du mage", 10, 10));
                Equipe equipe5 = new Equipe();
                equipe5.ajouter(g9);
                equipe5.ajouter(g10);
                return equipe5;
            case 5:
                Personnage g11 = new Guerisseur(20, 1, "guerisseur", new BaguetteMagique("baton du guerisseur", 10, 10));
                Personnage g12 = new Sorcier(20, 1, "mage", new BaguetteMagique("baton du mage", 10, 10));
                Equipe equipe6 = new Equipe();
                equipe6.ajouter(g11);
                equipe6.ajouter(g12);
                return equipe6;
            default:
                return null;

        }
    }
}

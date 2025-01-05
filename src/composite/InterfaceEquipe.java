package composite;

import visiteur.VisiteurPerso;

public interface InterfaceEquipe {

    /**
     * Permet d'accepter un visiteur
     * @param v le visiteur
     */
    void accept(VisiteurPerso v);
}

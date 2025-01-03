package jeu;

import visiteur.VisiteurPerso;
import composite.InterfaceEquipe;
import java.util.ArrayList;

public class Equipe implements InterfaceEquipe {

    ArrayList<InterfaceEquipe> listeEquipe = new ArrayList<>();

    public void accept(VisiteurPerso v) {
        v.visite(this);
    }

    public void ajouter(InterfaceEquipe e) {
        listeEquipe.add(e);
    }

    public void supprimer(InterfaceEquipe e) {
        listeEquipe.remove(e);
    }

    public InterfaceEquipe getChild(int i) {
        return listeEquipe.get(i);
    }

    public int getSize() {
        return listeEquipe.size();
    }
}

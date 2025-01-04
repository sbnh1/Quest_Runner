package jeu;

import visiteur.VisiteurPerso;
import composite.InterfaceEquipe;
import java.util.ArrayList;

public class Equipe implements InterfaceEquipe {

    ArrayList<InterfaceEquipe> listeEquipe = new ArrayList<>();
    private String nom;

    public Equipe(String nom){
        this.nom = nom;
    }

    public Equipe(){
        this.nom = "equipeSansNom";
    }

    public String getNom(){
        return nom;
    }

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

    public Personnage getPersonnage(int index) {
        // Vérifier que l'élément à l'index est bien un Personnage
        if (index >= 0 && index < listeEquipe.size()) {
            InterfaceEquipe membre = listeEquipe.get(index);
            if (membre instanceof Personnage) {
                return (Personnage) membre;
            }
        }
        return null;  // Retourne null si l'index est invalide ou si ce n'est pas un Personnage
    }

    public void ameliorer(){
        for (InterfaceEquipe membre : listeEquipe) {
            if (membre instanceof Personnage) {
                Personnage perso = (Personnage) membre;
                perso.augmenterLvl();
                System.out.println(perso.getNom() + " a été amélioré !");
            }
        }
    }

    public void afficherEquipe() {
        System.out.println("Équipe " + nom + " :");
        for (InterfaceEquipe membre : listeEquipe) {
            if (membre instanceof Personnage) {
                Personnage perso = (Personnage) membre;
                System.out.println("- " + perso.getNom() + " (PV : " + perso.getPointsDeVie() + ")");
            }
        }
    }

    public Personnage[] getMembres() {
        Personnage[] membres = new Personnage[listeEquipe.size()];
        for (int i = 0; i < listeEquipe.size(); i++) {
            membres[i] = (Personnage) listeEquipe.get(i);
        }
        return membres;
    }
}

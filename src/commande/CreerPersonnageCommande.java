package commande;

import facade.Jeu;
import jeu.*;
import fabrique.*;

public class CreerPersonnageCommande implements Commande {
    private Jeu jeu;
    private Equipe equipe;
    private Fabrique fabrique;
    private Personnage personnage;

    public CreerPersonnageCommande(Jeu jeu, Equipe equipe, Fabrique fabrique) {
        this.jeu = jeu;
        this.equipe = equipe;
        this.fabrique = fabrique;
    }

    @Override
    public void executer() {
        personnage = fabrique.creerPersonnage();
        equipe.ajouter(personnage);
        System.out.println("Personnage " + personnage.getNom() + " créé");
    }

    @Override
    public void defaire() {
        equipe.retirer(personnage);
        System.out.println("Création de " + personnage.getNom() + " annulée");
    }
}

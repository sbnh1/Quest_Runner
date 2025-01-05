package commande;

import facade.Jeu;
import jeu.*;
import fabrique.*;

public class CreerPersonnageCommande implements Commande {
    private Jeu jeu;
    private Equipe equipe;
    private Fabrique fabrique;
    private Personnage personnage;

    /**
     * Constructeur de la commande de création de personnage
     * @param jeu Jeu
     * @param equipe Equipe
     * @param fabrique Fabrique
     */
    public CreerPersonnageCommande(Jeu jeu, Equipe equipe, Fabrique fabrique) {
        this.jeu = jeu;
        this.equipe = equipe;
        this.fabrique = fabrique;
    }

    /**
     * Permet d'executer une commande
     */
    @Override
    public void executer() {
        personnage = fabrique.creerPersonnage();
        equipe.ajouter(personnage);
        System.out.println("Personnage " + personnage.getNom() + " créé");
    }

    /**
     * Permet de defaire une commande
     */
    @Override
    public void defaire() {
        equipe.retirer(personnage);
        System.out.println("Création de " + personnage.getNom() + " annulée");
    }
}

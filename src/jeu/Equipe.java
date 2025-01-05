package jeu;

import visiteur.VisiteurPerso;
import composite.InterfaceEquipe;
import java.util.ArrayList;

public class Equipe implements InterfaceEquipe {

    ArrayList<InterfaceEquipe> listeEquipe = new ArrayList<>();
    private String nom;

    /**
     * Constructeur de la classe Equipe.
     * @param nom Le nom de l'équipe.
     */
    public Equipe(String nom){
        this.nom = nom;
    }

    /**
     * Constructeur de la classe Equipe sans nom.
     */
    public Equipe(){
        this.nom = "equipeSansNom";
    }

    /**
     * Obtient le nom de l'équipe.
     * @return Le nom de l'équipe.
     */
    public String getNom(){
        return nom;
    }

    /**
     * accepte un visiteur.
     * @param v Le visiteur.
     */
    public void accept(VisiteurPerso v) {
        v.visite(this);
    }

    /**
     * Ajoute une équipe à la liste des équipes.
     * @param e L'équipe à ajouter.
     */
    public void ajouter(InterfaceEquipe e) {
        listeEquipe.add(e);
    }

    /**
     * Supprime une équipe de la liste des équipes.
     * @param e L'équipe à supprimer.
     */
    public void supprimer(InterfaceEquipe e) {
        listeEquipe.remove(e);
    }

    /**
     * Obtient l'équipe à l'index donné.
     * @param i L'index de l'équipe.
     */
    public InterfaceEquipe getChild(int i) {
        return listeEquipe.get(i);
    }

    /**
     * Obtient la taille de l'équipe.
     * @return La taille de l'équipe.
     */
    public int getSize() {
        return listeEquipe.size();
    }

    /**
     * Obtient le personnage à l'index donné.
     * @param index L'index du personnage.
     * @return Le personnage à l'index donné.
     */
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

    /**
     * Augmente le niveau de tous les personnages de l'équipe.
     */
    public void ameliorer(){
        for (InterfaceEquipe membre : listeEquipe) {
            if (membre instanceof Personnage) {
                Personnage perso = (Personnage) membre;
                perso.augmenterLvl();
                System.out.println(perso.getNom() + " a été amélioré !");
            }
        }
    }

    /**
     * Affiche les membres de l'équipe.
     */
    public void afficherEquipe() {
        if(nom != "equipeSansNom"){
            System.out.println("Équipe " + nom + " :");
        }
        for (InterfaceEquipe membre : listeEquipe) {
            if (membre instanceof Personnage) {
                Personnage perso = (Personnage) membre;
                System.out.println("- " + perso.getNom() + " (PV : " + perso.getPointsDeVie() + ")");
            }
        }
    }

    /**param nom Le nom du personnage.
     * @return Le personnage avec le nom donné.
     * Obtient les membres de l'équipe.
     * @return Les membres de l'équipe.
     */
    public Personnage[] getMembres() {
        Personnage[] membres = new Personnage[listeEquipe.size()];
        for (int i = 0; i < listeEquipe.size(); i++) {
            membres[i] = (Personnage) listeEquipe.get(i);
        }
        return membres;
    }

    /**
     * Retire un personnage à l'équipe.
     * @param personnage Le personnage à retirer.
     */
    public void retirer(Personnage personnage) {
        for (int i = 0; i < listeEquipe.size(); i++) {
            InterfaceEquipe membre = listeEquipe.get(i);
            if (membre instanceof Personnage && membre.equals(personnage)) {
                listeEquipe.remove(i);
                System.out.println(personnage.getNom() + " a été retiré de l'équipe");
                return;
            }
        }
        System.out.println("erreur lors de la suppression de : " + personnage.getNom());
    }
}

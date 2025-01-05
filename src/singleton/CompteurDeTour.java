package singleton;

public class CompteurDeTour {
    private static CompteurDeTour instance = new CompteurDeTour();
    private int compteur = 0;

    /**
     * Constructeur de la classe CompteurDeTour
     */
    private CompteurDeTour() {
    }

    /**
     * Méthode pour récupérer l'instance de la classe CompteurDeTour
     * @return instance Instance de la classe CompteurDeTour
     */
    public static CompteurDeTour getInstance() {
        return instance;
    }

    /**
     * Méthode pour ajouter un tour
     */
    public void ajouterUnTour() {
        compteur++;
    }

    /**
     * Méthode pour récupérer le compteur
     * @return compteur Compteur
     */
    public int getCompteur() {
        return compteur;
    }

    /**
     * Méthode pour réinitialiser le compteur
     */
    public void reset() {
        compteur = 0;
    }
}

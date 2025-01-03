package singleton;

public class CompteurDeTour {
    private static CompteurDeTour instance = new CompteurDeTour();
    private int compteur = 0;

    private CompteurDeTour() {
    }

    public static CompteurDeTour getInstance() {
        return instance;
    }

    public void ajouterUnTour() {
        compteur++;
    }

    public int getCompteur() {
        return compteur;
    }

    public void reset() {
        compteur = 0;
    }
}

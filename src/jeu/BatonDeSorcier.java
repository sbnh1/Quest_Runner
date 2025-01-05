package jeu;

public class BatonDeSorcier extends Arme {
    private String pouvoir;

    /**
     * Constructeur de la classe BatonDeSorcier avec un pouvoir par défaut de "feu" et un soin de 5.
     * @param nom   Le nom du bâton de sorcier.
     * @param degat Les dégâts du bâton de sorcier.
     * @param poids Le poids du bâton de sorcier.
     */
    public BatonDeSorcier(String nom, int degat, double poids) {
        super(nom, degat, poids);
        this.pouvoir = "feu";
        this.soin = 5;
    }

    /**
     * Constructeur de la classe BatonDeSorcier.
     * @param nom     Le nom du bâton de sorcier.
     * @param degat   Les dégâts du bâton de sorcier.
     * @param poids   Le poids du bâton de sorcier.
     * @param pouvoir Le pouvoir du bâton de sorcier.
     */
    public BatonDeSorcier(String nom, int degat, double poids, String pouvoir) {
        super(nom, degat, poids);
        this.pouvoir = pouvoir;
    }

    /**
     * Obtient le pouvoir du bâton de sorcier.
     * @return Le pouvoir du bâton de sorcier.
     */
    public String getPouvoir() {
        return pouvoir;
    }

    /**
     * Définit le pouvoir du bâton de sorcier.
     * @param pouvoir Le nouveau pouvoir du bâton de sorcier.
     */
    public void setPouvoir(String pouvoir) {
        this.pouvoir = pouvoir;
    }
}


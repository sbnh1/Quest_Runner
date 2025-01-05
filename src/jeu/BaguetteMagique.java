package jeu;

public class BaguetteMagique extends Arme {
    private int soin;

    /**
     * Constructeur de la classe BaguetteMagique avec un soin par défaut de 10.
     * @param nom   Le nom de la baguette magique.
     * @param degat Les dégâts de la baguette magique.
     * @param poids Le poids de la baguette magique.
     */
    public BaguetteMagique(String nom, int degat, double poids) {
        super(nom, degat, poids);
        this.soin = 10;
    }

    /**
     * Constructeur de la classe BaguetteMagique.
     * @param nom   Le nom de la baguette magique.
     * @param degat Les dégâts de la bag
     * @param poids Le poids de la baguette magique.
     * @param soin  Le soin de la baguette magique.
     */
    public BaguetteMagique(String nom, int degat, double poids, int soin) {
        super(nom, degat, poids);
        this.soin = soin;
    }
}


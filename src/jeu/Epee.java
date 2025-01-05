package jeu;

public class Epee extends Arme {
    private int longueur;

    /**
     * Constructeur de la classe Epee avec une longueur par défaut de 10 et un soin de 0.
     * @param nom    Le nom de l'épée.
     * @param degat  Les dégâts de l'épée.
     * @param poids  Le poids de l'épée.
     * @param longueur La longueur de l'épée.
     */
    public Epee(String nom, int degat, double poids, int longueur) {
        super(nom, degat, poids);
        this.longueur = longueur;
        this.soin = 0;
    }

    /**
     * Constructeur de la classe Epee avec une longueur par défaut de 10 et un soin de 0.
     * @param nom    Le nom de l'épée.
     * @param degat  Les dégâts de l'épée.
     * @param poids  Le poids de l'épée.
     */
    public Epee(String nom, int degat, double poids){
        super(nom, degat, poids);
        this.longueur = 10;
    }

    /**
     * Obtient la longueur de l'épée.
     * @return La longueur de l'épée.
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * Définit la longueur de l'épée.
     * @param longueur La nouvelle longueur de l'épée.
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}


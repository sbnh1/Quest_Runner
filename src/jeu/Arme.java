package jeu;

public abstract class Arme {
    protected int degat;
    protected String nom;
    protected double poids;
    protected int soin;

    /**
     * Constructeur de la classe Arme.
     * @param nom   Le nom de l'arme.
     * @param degat Les dégâts de l'arme.
     * @param poids Le poids de l'arme.
     */
    public Arme(String nom, int degat, double poids) {
        this.nom = nom;
        this.degat = degat;
        this.poids = poids;
        this.soin = 0;
    }

    /**
     * Obtient les dégâts de l'arme.
     * @return Les dégâts de l'arme.
     */
    public int getDegat() {
        return degat;
    }

    /**
     * Définit les dégâts de l'arme.
     * @param degat Les nouveaux dégâts de l'arme.
     */
    public void setDegat(int degat) {
        this.degat = degat;
    }

    /**
     * Obtient le nom de l'arme.
     * @return Le nom de l'arme.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'arme.
     * @param nom Le nouveau nom de l'arme.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le poids de l'arme.
     * @return Le poids de l'arme.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Définit le poids de l'arme.
     * @param poids Le nouveau poids de l'arme.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Augmente les dégâts de l'arme.
     * @param degatAugmente La quantité de dégâts à ajouter.
     */
    public void augmenterDegat(int degatAugmente){
        this.degat += degatAugmente;
    }

    /**
     * Obtient les points de soin de l'arme.
     * @return Les points de soin de l'arme.
     */
    public int getSoin(){
        return soin;
    }

    /**
     * Définit les points de soin de l'arme.
     * @param soin Les nouveaux points de soin de l'arme.
     */
    public void setSoin(int soin){
        this.soin = soin;
    }

    /**
     * Augmente les points de soin de l'arme.
     * @param soin La quantité de points de soin à ajouter.
     */
    public void augmenterSoin(int soin){
        this.soin += soin;
    }
}


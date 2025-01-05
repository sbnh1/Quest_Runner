package jeu;

public abstract class Arme {
    protected int degat;
    protected String nom;
    protected double poids;
    protected int soin;

    public Arme(String nom, int degat, double poids) {
        this.nom = nom;
        this.degat = degat;
        this.poids = poids;
        this.soin = 0;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void augmenterDegat(int degatAugmente){
        this.degat += degatAugmente;
    }

    public int getSoin(){
        return soin;
    }

    public void setSoin(int soin){
        this.soin = soin;
    }

    public void augmenterSoin(int soin){
        this.soin += soin;
    }
}


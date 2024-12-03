package jeu;

public abstract class Arme {
    private int degat;
    private String nom;
    private double poids;

    public Arme(String nom, int degat, double poids) {
        this.nom = nom;
        this.degat = degat;
        this.poids = poids;
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
}


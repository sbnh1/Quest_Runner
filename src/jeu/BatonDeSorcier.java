package jeu;

public class BatonDeSorcier extends Arme {
    private String pouvoir;

    public BatonDeSorcier(String nom, int degat, double poids) {
        super(nom, degat, poids);
        this.pouvoir = "feu";
    }

    public BatonDeSorcier(String nom, int degat, double poids, String pouvoir) {
        super(nom, degat, poids);
        this.pouvoir = pouvoir;
    }

    public String getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(String pouvoir) {
        this.pouvoir = pouvoir;
    }
}


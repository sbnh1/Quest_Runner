package jeu;

public class Roi extends Personnage {
    private int force;
    private String royaume;

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getRoyaume() {
        return royaume;
    }

    public void setRoyaume(String royaume) {
        this.royaume = royaume;
    }
}
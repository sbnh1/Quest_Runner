package strategie;

import jeu.Personnage;

public class ModeDefense implements Strategie {

    /**
     * Méthode pour choisir la stratégie de combat
     * @param personnage Personnage
     */
    @Override
    public void choisirStrategieDeCombat(Personnage personnage) {
        System.out.println("Mode defense");
        if(personnage.getStrategie() == 1){
            personnage.diminuerDegat();
            personnage.augmenterDefense();
        }
        personnage.setStrategie(2);
        personnage.diminuerDegat();
        personnage.augmenterDefense();
    }
}

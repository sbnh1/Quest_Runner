package strategie;

import jeu.Personnage;

public class ModeNormal implements Strategie {

    /**
     * Méthode pour choisir la stratégie de combat
     * @param personnage Personnage
     */
    @Override
    public void choisirStrategieDeCombat(Personnage personnage) {
        System.out.println("Mode normal");
        if(personnage.getStrategie() == 1){
            personnage.diminuerDegat();
            personnage.augmenterDefense();
        } else if (personnage.getStrategie() == 2){
            personnage.diminuerDefense();
            personnage.augmenterDegat();
        }
    }
}

package strategie;

import jeu.Personnage;

public class ModeAttaque implements Strategie {

    @Override
    public void choisirStrategieDeCombat(Personnage personnage) {
        System.out.println("Mode attaque");
        if(personnage.getStrategie() == 2){
            personnage.diminuerDegat();
            personnage.augmenterDefense();
        }
        personnage.setStrategie(1);
        personnage.augmenterDegat();
        personnage.diminuerDefense();
    }

}

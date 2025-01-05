package commande;

import java.util.Stack;

public class CommandeManager {
    private Stack<Commande> history = new Stack<>();

    /**
     * Execute une commande et l'ajoute à l'historique
     * @param command La commande à executer
     */
    public void executerCommande(Commande command) {
        command.executer();
        history.push(command);
    }

    /**
     * Annule la dernière commande
     */
    public void defaireDerniereCommande() {
        if (!history.isEmpty()) {
            Commande lastCommand = history.pop();
            lastCommand.defaire();
        } else {
            System.out.println("Aucune commande à annuler.");
        }
    }
}

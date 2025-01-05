package commande;

import java.util.Stack;

public class CommandeManager {
    private Stack<Commande> history = new Stack<>();

    public void executerCommande(Commande command) {
        command.executer();
        history.push(command);
    }

    public void defaireDerniereCommande() {
        if (!history.isEmpty()) {
            Commande lastCommand = history.pop();
            lastCommand.defaire();
        } else {
            System.out.println("Aucune commande à annuler.");
        }
    }
}

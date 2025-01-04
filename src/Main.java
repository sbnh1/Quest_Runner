import facade.Jeu;
import fabrique.*;
import jeu.*;
import composite.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        FabriqueEquipe fabriqueEquipe = new FabriqueEquipe();
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de créer une équipe
        System.out.println("Créez votre équipe");
        System.out.print("Entrez le nom de l'équipe : ");
        String nomEquipe = scanner.nextLine();
        System.out.print("Entrez le nombre de personnages (2-4) : ");
        int nbPersonnages = scanner.nextInt();
        scanner.nextLine();

        // Créer l'équipe de l'utilisateur
        Equipe membresEquipeUtilisateur = new Equipe(nomEquipe);

        for (int i = 0; i < nbPersonnages; i++) {
            // Choix des personnages que l'utilisateurs souhaite
            System.out.println("Choisissez le type de personnage pour le membre " + (i + 1) + " :");
            System.out.println("1 - Roi");
            System.out.println("2 - Sorcier");
            System.out.println("3 - Guerrier");
            System.out.println("4 - Guérisseur");

            int choix = scanner.nextInt();
            scanner.nextLine();

            Personnage personnage = null;

            // Création du personnage
            switch (choix) {
                case 1:
                    FabriqueRoi roi = new FabriqueRoi();
                    personnage = roi.creerPersonnage();
                    break;
                case 2:
                    FabriqueSorcier sorcier = new FabriqueSorcier();
                    personnage = sorcier.creerPersonnage();
                    break;
                case 3:
                    FabriqueGuerrier guerrier = new FabriqueGuerrier();
                    personnage = guerrier.creerPersonnage();
                    break;
                case 4:
                    FabriqueGuerisseur guerisseur = new FabriqueGuerisseur();
                    personnage = guerisseur.creerPersonnage();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez choisir un nombre entre 1 et 4.");
                    i--;
                    continue;
            }

            membresEquipeUtilisateur.ajouter(personnage);
        }
        jeu.ajouterEquipe(membresEquipeUtilisateur);


        // Jouer tant que l'équipe utilisateur gagne
        while (true) {
            // Créer une équipe ennemie
            InterfaceEquipe equipeEnnemie = fabriqueEquipe.creerEquipe();

            System.out.println("Equipe Utilisateur :");
            jeu.afficherEquipes();

            System.out.println("Equipe Ennemie :");
            if (equipeEnnemie instanceof Equipe) {
                Equipe equipeEnnemie1 = (Equipe) equipeEnnemie; // Cast sûr après vérification
                System.out.println("Equipe Ennemie :");
                equipeEnnemie1.afficherEquipe();
            } else {
                System.out.println("Affichage non disponible pour l'équipe ennemie.");
            }

            // Lancement du combat
            boolean equipeUtilisateurGagne = jeu.combat(jeu, membresEquipeUtilisateur, equipeEnnemie);

            if (equipeUtilisateurGagne) {
                // L'équipe utilisateur gagne
                System.out.println("Victoire de l'équipe utilisateur !\n\n");
                jeu.ameliorerEquipe(nomEquipe);
            } else {
                // L'équipe utilisateur perd
                System.out.println("L'équipe utilisateur a perdu !");
                break;
            }
        }
        scanner.close();
    }



}

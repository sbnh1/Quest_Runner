package facade;

import composite.InterfaceEquipe;
import jeu.*;
import singleton.CompteurDeTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private List<Equipe> equipes;

    public Jeu(){
        this.equipes = new ArrayList<>();
    }

    public void creerEquipe(String nomEquipe, List<Personnage> membresEquipe){
        Equipe equipe = new Equipe(nomEquipe);
        for (Personnage membre : membresEquipe) {
            equipe.ajouter(membre);
        }
        equipes.add(equipe);

    }

    public void ajouterEquipe(Equipe equipe) {
        equipes.add(equipe);
    }


    public void ajouterMembreEquipe(String nomEquipe, Personnage nouveauMembre) {
        // Chercher l'équipe par son nom
        Equipe equipe = trouverEquipeParNom(nomEquipe);

        // Vérifier si l'équipe a été trouvée
        if (equipe != null) {
            // Ajouter le nouveau membre à l'équipe
            equipe.ajouter(nouveauMembre);
            System.out.println("Membre ajouté à l'équipe " + nomEquipe + ".");
        } else {
            // L'équipe n'a pas été trouvée
            System.out.println("L'équipe " + nomEquipe + " n'existe pas.");
        }
    }

    public void afficherEquipes() {
        for (Equipe equipe : equipes) {
            equipe.afficherEquipe();
        }
    }

    public void supprimerEquipe(String nomEquipeASupprimer){
        equipes.removeIf(equipe -> equipe.getNom().equals(nomEquipeASupprimer));
        System.out.println("Equipe : " + nomEquipeASupprimer + " supprimée");
    }

    public void faireAttaque(Personnage attaquant, Personnage cible) {
        attaquant.attaquer(cible);
    }

    public void faireSoigner(Personnage attaquant, Personnage cible){
        attaquant.soigner(cible);
    }

    public void ameliorerEquipe(String nomEquipe){
        Equipe equipe = trouverEquipeParNom(nomEquipe);
        if (equipe != null) {
            equipe.ameliorer();
            System.out.println("Équipe " + nomEquipe + " améliorée !");
        } else {
            System.out.println("Équipe " + nomEquipe + " introuvable.");
        }
    }

    private Equipe trouverEquipeParNom(String nomEquipe) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equals(nomEquipe)) {
                return equipe;
            }
        }
        return null;
    }


    // Méthode pour gérer le combat entre les équipes
    public static boolean combat(Jeu jeu, Equipe equipeUtilisateur, InterfaceEquipe equipeEnnemie) {
        // Initialiser le compteur de tours (Singleton)
        CompteurDeTour compteurDeTour = CompteurDeTour.getInstance();

        Random random = new Random();
        if (equipeEnnemie instanceof Equipe) {
            Equipe equipe = (Equipe) equipeEnnemie;

            // Accéder aux personnages de l'équipe ennemie
            Personnage personnageEnnemie1 = equipe.getPersonnage(0);
            Personnage personnageEnnemie2 = equipe.getPersonnage(1);

            // Combat entre l'équipe utilisateur et l'équipe ennemie. Demander action pour chaque personnage, incrémenter de 1 le compteur de tour
            while (true) {
                System.out.println("\n\nTour " + compteurDeTour.getCompteur() + " :");
                for (int i = 0; i < equipeUtilisateur.getSize(); i++) {
                    Personnage personnage = equipeUtilisateur.getPersonnage(i);
                    System.out.println("C'est au tour de " + personnage.getNom() + " de jouer.");
                    System.out.println("1 - Attaquer");
                    System.out.println("2 - Soigner");
                    System.out.println("3 - Passer Mode Attaque");
                    System.out.println("4 - Passer Mode Défense");
                    System.out.println("5 - Passer Mode Neutre");
                    System.out.println("6 - Quitter");

                    Scanner scanner = new Scanner(System.in);
                    int choix = scanner.nextInt();
                    scanner.nextLine();  // Consommer le reste de la ligne

                    switch (choix) {
                        case 1:
                            int choixAction = random.nextInt(2);
                            if (choixAction == 0) {
                                jeu.faireAttaque(personnage, personnageEnnemie1);  // Attaquer le premier personnage ennemi
                            } else {
                                jeu.faireAttaque(personnage, personnageEnnemie2);  // Attaquer le deuxième personnage ennemi
                            }
                            break;
                        case 2:
                            choixAction = random.nextInt(2);
                            if (choixAction == 0) {
                                jeu.faireSoigner(personnage, personnage);
                            } else {
                                jeu.faireSoigner(personnage, personnage);
                            }
                            break;
                        case 3:
                            personnage.choisirModeAttaque();
                            break;
                        case 4:
                            personnage.choisirModeDefense();
                            break;
                        case 5:
                            personnage.choisirModeNormal();
                            break;
                        case 6:
                            System.out.println("Vous avez quitté le combat.");
                            return false;
                        default:
                            System.out.println("Choix invalide, veuillez choisir 1 ou 2.");
                            break;
                    }
                }

                // Ennemi attaque aléatoirement un personnage de l'équipe utilisateur
                random = new Random();
                System.out.println("\n");

                int choixEnnemi1 = random.nextInt(equipeUtilisateur.getSize());
                Personnage personnageUtilisateur1 = equipeUtilisateur.getPersonnage(choixEnnemi1);
                jeu.faireAttaque(personnageEnnemie1, personnageUtilisateur1);

                int choixEnnemi2 = random.nextInt(equipeUtilisateur.getSize());
                Personnage personnageUtilisateur2 = equipeUtilisateur.getPersonnage(choixEnnemi2);
                jeu.faireAttaque(personnageEnnemie2, personnageUtilisateur2);
                System.out.println("\n");

                // Vérifier si l'équipe utilisateur a été vaincue
                boolean tousMorts = true;
                for (int i = 0; i < equipeUtilisateur.getSize(); i++) {
                    Personnage personnage = equipeUtilisateur.getPersonnage(i);
                    if (personnage.getPointsDeVie() > 0) {
                        tousMorts = false;
                        break;
                    }
                }
                if (tousMorts == true) {
                    System.out.println("Vous avez survécu pendant " + compteurDeTour.getCompteur() + " tours.");
                    return false;
                }


                // Vérifier si l'équipe ennemie a été vaincue
                if (personnageEnnemie1.getPointsDeVie() != 0 && personnageEnnemie2.getPointsDeVie() != 0) {
                    System.out.println("L'équipe ennemie n'a pas été vaincue.");
                    compteurDeTour.ajouterUnTour();
                    continue;
                } else {
                    // L'équipe ennemie a été vaincue
                    System.out.println("L'équipe ennemie a été vaincue.");
                    compteurDeTour.ajouterUnTour();
                    return true;
                }

            }
        } else {
            System.out.println("L'équipe ennemie n'est pas valide.");
            return false;
        }
    }
}

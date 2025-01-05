package facade;

import commande.CommandeManager;
import commande.Commande;
import commande.CreerPersonnageCommande;
import composite.InterfaceEquipe;
import fabrique.*;
import jeu.*;
import singleton.CompteurDeTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private List<Equipe> equipes;
    private CommandeManager commandManager = new CommandeManager();


    public Jeu() {
        this.equipes = new ArrayList<>();
    }

    public void creerEquipe(String nomEquipe, List<Personnage> membresEquipe) {
        Equipe equipe = new Equipe(nomEquipe);
        for (Personnage membre : membresEquipe) {
            equipe.ajouter(membre);
        }
        equipes.add(equipe);

    }

    public void ajouterEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    private void ajouterMembreEquipe(String nomEquipe, Personnage nouveauMembre) {
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

    private void afficherEquipes() {
        for (Equipe equipe : equipes) {
            equipe.afficherEquipe();
        }
    }

    private void supprimerEquipe(String nomEquipeASupprimer) {
        equipes.removeIf(equipe -> equipe.getNom().equals(nomEquipeASupprimer));
        System.out.println("Equipe : " + nomEquipeASupprimer + " supprimée");
    }

    private void faireAttaque(Personnage attaquant, Personnage cible) {
        attaquant.attaquer(cible);
    }

    private void faireSoigner(Personnage attaquant, Personnage cible) {
        attaquant.soigner(cible);
    }

    private void ameliorerEquipe(String nomEquipe) {
        Equipe equipe = trouverEquipeParNom(nomEquipe);
        if (equipe != null) {
            equipe.ameliorer();
            System.out.println("Équipe " + nomEquipe + " améliorée !");
        } else {
            System.out.println("Équipe " + nomEquipe + " introuvable.");
        }
    }

    private void updateEtatEquipe(String nomEquipe) {
        Equipe equipe = trouverEquipeParNom(nomEquipe);
        for(Personnage personnage : equipe.getMembres()){
            personnage.updateEtat();
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
    private boolean combat(Jeu jeu, Equipe equipeUtilisateur, InterfaceEquipe equipeEnnemie) {
        // Initialiser le compteur de tours (Singleton)
        CompteurDeTour compteurDeTour = CompteurDeTour.getInstance();

        Random random = new Random();
        if (equipeEnnemie instanceof Equipe) {
            Equipe equipe = (Equipe) equipeEnnemie;

            // Accéder aux personnages de l'équipe ennemie
            Personnage personnageEnnemie1 = equipe.getPersonnage(0);
            Personnage personnageEnnemie2 = equipe.getPersonnage(1);


            // Augmentation de la vie et des degats des ennemis
            int upDegat = (int) (0.9 * compteurDeTour.getCompteur());
            int upVie = (int) (0.9 * compteurDeTour.getCompteur());

            personnageEnnemie2.getArme().augmenterDegat(upDegat);
            personnageEnnemie1.getArme().augmenterDegat(upDegat);

            personnageEnnemie1.setMaxPointDeVie(personnageEnnemie1.getMaxPointsDeVie() + upVie);
            personnageEnnemie1.setPointsDeVie(personnageEnnemie1.getPointsDeVie() + upVie);
            personnageEnnemie2.setMaxPointDeVie(personnageEnnemie1.getMaxPointsDeVie() + upVie);
            personnageEnnemie2.setPointsDeVie(personnageEnnemie1.getPointsDeVie() + upVie);


            // Combat entre l'équipe utilisateur et l'équipe ennemie. Demander action pour chaque personnage, incrémenter de 1 le compteur de tour
            while (true) {
                System.out.println("\n\nTour " + compteurDeTour.getCompteur() + " :");
                for (int i = 0; i < equipeUtilisateur.getSize(); i++) {
                    Personnage personnage = equipeUtilisateur.getPersonnage(i);
                    if(personnage.getPointsDeVie() != 0){
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
                    } else {
                        System.out.println(personnage.getNom() + " est mort, il ressuscitera à la prochaine horde");
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


    public void initialisation() {
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
            // Choix des personnages que l'utilisateur souhaite
            System.out.println("Choisissez le type de personnage pour le membre " + (i + 1) + " :");
            System.out.println("1 - Roi");
            System.out.println("2 - Sorcier");
            System.out.println("3 - Guerrier");
            System.out.println("4 - Guérisseur");

            int choix = scanner.nextInt();
            scanner.nextLine();

            Commande CreerPersonnageCommande;
            Personnage personnage = null;

            // Création de la commande pour le personnage
            switch (choix) {
                case 1:
                    CreerPersonnageCommande = new CreerPersonnageCommande(this, membresEquipeUtilisateur, new FabriqueRoi());
                    break;
                case 2:
                    CreerPersonnageCommande = new CreerPersonnageCommande(this, membresEquipeUtilisateur, new FabriqueSorcier());
                    break;
                case 3:
                    CreerPersonnageCommande = new CreerPersonnageCommande(this, membresEquipeUtilisateur, new FabriqueGuerrier());
                    break;
                case 4:
                    CreerPersonnageCommande = new CreerPersonnageCommande(this, membresEquipeUtilisateur, new FabriqueGuerisseur());
                    break;
                default:
                    System.out.println("Choix invalide, veuillez choisir un nombre entre 1 et 4.");
                    i--;
                    continue;
            }

            // Exécution de la commande
            commandManager.executerCommande(CreerPersonnageCommande);

            // Option pour annuler la commande
            System.out.println("Voulez-vous annuler la création de ce personnage ? (oui/non)");
            String annuler = scanner.nextLine().trim().toLowerCase();
            if (annuler.equals("oui")) {
                commandManager.defaireDerniereCommande();
                i--;
            }
        }

        this.ajouterEquipe(membresEquipeUtilisateur);

        // Suite de l'initialisation (combat, amélioration, etc.)
        while (true) {
            // Reste du code inchangé pour le combat
            InterfaceEquipe equipeEnnemie = fabriqueEquipe.creerEquipe();
            System.out.println("Equipe Utilisateur :");
            this.afficherEquipes();
            System.out.println("Equipe Ennemie :");
            if (equipeEnnemie instanceof Equipe) {
                Equipe equipeEnnemie1 = (Equipe) equipeEnnemie;
                equipeEnnemie1.afficherEquipe();
            } else {
                System.out.println("Affichage non disponible pour l'équipe ennemie");
            }
            boolean equipeUtilisateurGagne = this.combat(this, membresEquipeUtilisateur, equipeEnnemie);

            if (equipeUtilisateurGagne) {
                System.out.println("Victoire de l'équipe utilisateur !\n\n");
                this.ameliorerEquipe(nomEquipe);
                this.updateEtatEquipe(nomEquipe);
            } else {
                System.out.println("L'équipe utilisateur a perdu !");
                break;
            }
        }
        scanner.close();
    }

}
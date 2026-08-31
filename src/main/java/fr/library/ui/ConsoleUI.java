package fr.library.ui;

import fr.library.model.Bibliothecaire;
import fr.library.model.Etudiant;
import fr.library.model.Genre;
import fr.library.model.Livre;
import fr.library.repository.IRepository;
import fr.library.service.BibliothequeService;

import java.util.Scanner;

public class ConsoleUI {

    private BibliothequeService service;
    private IRepository<Livre> livreRepo;
    private IRepository<fr.library.model.Utilisateur> utilisateurRepo;
    private Scanner scanner;
    private int livreIdCounter = 1;
    private int utilisateurIdCounter = 1;

    public ConsoleUI(BibliothequeService service, IRepository<Livre> livreRepo, IRepository<fr.library.model.Utilisateur> utilisateurRepo) {
        this.service = service;
        this.livreRepo = livreRepo;
        this.utilisateurRepo = utilisateurRepo;
        this.scanner = new Scanner(System.in);
    }

    public void demarrer() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n=================================");
            System.out.println("       LIBRARY MANAGER");
            System.out.println("=================================");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Lister les livres");
            System.out.println("3. Ajouter un utilisateur");
            System.out.println("4. Lister les utilisateurs");
            System.out.println("5. Emprunter un livre");
            System.out.println("6. Retourner un livre");
            System.out.println("7. Rechercher un livre");
            System.out.println("8. Quitter");
            System.out.print("Votre choix : ");

            String choix = scanner.nextLine();

            try {
                switch (choix) {
                    case "1": ajouterLivre(); break;
                    case "2": listerLivres(); break;
                    case "3": ajouterUtilisateur(); break;
                    case "4": listerUtilisateurs(); break;
                    case "5": emprunterLivre(); break;
                    case "6": retournerLivre(); break;
                    case "7": rechercherLivre(); break;
                    case "8": continuer = false; break;
                    default: System.out.println("Choix invalide.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        System.out.println("Au revoir !");
    }

    private void ajouterLivre() {
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        System.out.print("Année de publication : ");
        int annee = Integer.parseInt(scanner.nextLine());
        
        Livre livre = new Livre(livreIdCounter++, titre, auteur, isbn, annee, Genre.ROMAN);
        livreRepo.ajouter(livre);
        System.out.println("Livre ajouté avec succès.");
    }

    private void listerLivres() {
        livreRepo.listerTout().forEach(System.out::println);
    }

    private void ajouterUtilisateur() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Type (1 = Etudiant, 2 = Bibliothécaire) : ");
        String type = scanner.nextLine();

        fr.library.model.Utilisateur u = type.equals("1") 
            ? new Etudiant(utilisateurIdCounter++, nom, prenom, email)
            : new Bibliothecaire(utilisateurIdCounter++, nom, prenom, email);

        utilisateurRepo.ajouter(u);
        System.out.println("Utilisateur ajouté avec succès.");
    }

    private void listerUtilisateurs() {
        utilisateurRepo.listerTout().forEach(System.out::println);
    }

    private void emprunterLivre() {
        System.out.print("ID du livre : ");
        int idLivre = Integer.parseInt(scanner.nextLine());
        System.out.print("ID de l'utilisateur : ");
        int idUtilisateur = Integer.parseInt(scanner.nextLine());
        
        try {
            service.emprunterLivre(idLivre, idUtilisateur);
            System.out.println("Emprunt effectué avec succès.");
        } catch (Exception e) {
            System.out.println("Échec de l'emprunt : " + e.getMessage());
        }
    }

    private void retournerLivre() {
        System.out.print("ID de l'emprunt : ");
        int idEmprunt = Integer.parseInt(scanner.nextLine());
        
        try {
            service.retournerLivre(idEmprunt);
            System.out.println("Livre retourné avec succès.");
        } catch (Exception e) {
            System.out.println("Échec du retour : " + e.getMessage());
        }
    }

    private void rechercherLivre() {
        System.out.print("Titre à rechercher : ");
        String titre = scanner.nextLine();
        service.rechercherLivreParTitre(titre).forEach(System.out::println);
    }
}
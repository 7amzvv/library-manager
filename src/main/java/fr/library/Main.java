package fr.library;

import fr.library.repository.EmpruntRepository;
import fr.library.repository.LivreRepository;
import fr.library.repository.UtilisateurRepository;
import fr.library.service.BibliothequeService;
import fr.library.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        LivreRepository livreRepo = new LivreRepository();
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        EmpruntRepository empruntRepo = new EmpruntRepository();

        BibliothequeService service = new BibliothequeService(livreRepo, utilisateurRepo, empruntRepo);

        ConsoleUI ui = new ConsoleUI(service, livreRepo, utilisateurRepo);
        ui.demarrer();
    }
}
package fr.library.service;

import fr.library.exception.LivreIndisponibleException;
import fr.library.exception.LivreIntrouvableException;
import fr.library.exception.UtilisateurIntrouvableException;
import fr.library.model.Emprunt;
import fr.library.model.Livre;
import fr.library.model.Utilisateur;
import fr.library.repository.IRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BibliothequeService {

    private IRepository<Livre> livreRepo;
    private IRepository<Utilisateur> utilisateurRepo;
    private IRepository<Emprunt> empruntRepo;
    private int empruntIdCounter = 1;

    public BibliothequeService(IRepository<Livre> livreRepo, IRepository<Utilisateur> utilisateurRepo, IRepository<Emprunt> empruntRepo) {
        this.livreRepo = livreRepo;
        this.utilisateurRepo = utilisateurRepo;
        this.empruntRepo = empruntRepo;
    }

    public void emprunterLivre(int idLivre, int idUtilisateur) throws LivreIntrouvableException, UtilisateurIntrouvableException, LivreIndisponibleException {
        Livre livre = livreRepo.trouverParId(idLivre)
                .orElseThrow(() -> new LivreIntrouvableException("Livre introuvable."));

        Utilisateur utilisateur = utilisateurRepo.trouverParId(idUtilisateur)
                .orElseThrow(() -> new UtilisateurIntrouvableException("Utilisateur introuvable."));

        if (!livre.isDisponible()) {
            throw new LivreIndisponibleException("Le livre est déjà emprunté.");
        }

        livre.setDisponible(false);
        livreRepo.modifier(livre);

        Emprunt emprunt = new Emprunt(empruntIdCounter++, livre, utilisateur, LocalDate.now(), LocalDate.now().plusDays(14));
        empruntRepo.ajouter(emprunt);
    }

    public void retournerLivre(int idEmprunt) throws Exception {
        Emprunt emprunt = empruntRepo.trouverParId(idEmprunt)
                .orElseThrow(() -> new Exception("Emprunt introuvable."));

        if (emprunt.isRetourne()) {
            throw new Exception("Ce livre a déjà été retourné.");
        }

        emprunt.setDateRetourEffective(LocalDate.now());
        empruntRepo.modifier(emprunt);

        Livre livre = emprunt.getLivre();
        livre.setDisponible(true);
        livreRepo.modifier(livre);
    }

    public List<Livre> rechercherLivreParTitre(String titre) {
        return livreRepo.listerTout().stream()
                .filter(l -> l.getTitre().toLowerCase().contains(titre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Livre> trierLivresParAnnee() {
        return livreRepo.listerTout().stream()
                .sorted(Comparator.comparingInt(Livre::getAnneePublication).reversed())
                .collect(Collectors.toList());
    }
}
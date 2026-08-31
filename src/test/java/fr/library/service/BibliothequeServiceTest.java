package fr.library.service;

import fr.library.exception.LivreIndisponibleException;
import fr.library.model.Etudiant;
import fr.library.model.Genre;
import fr.library.model.Livre;
import fr.library.repository.EmpruntRepository;
import fr.library.repository.LivreRepository;
import fr.library.repository.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliothequeServiceTest {

    private BibliothequeService service;
    private LivreRepository livreRepo;
    private UtilisateurRepository utilisateurRepo;
    private EmpruntRepository empruntRepo;

    @BeforeEach
    public void setUp() {
        livreRepo = new LivreRepository();
        utilisateurRepo = new UtilisateurRepository();
        empruntRepo = new EmpruntRepository();
        service = new BibliothequeService(livreRepo, utilisateurRepo, empruntRepo);

        Livre livre = new Livre(1, "Java pour les nuls", "Auteur X", "12345", 2023, Genre.INFORMATIQUE);
        livreRepo.ajouter(livre);

        Etudiant etudiant = new Etudiant(1, "Fadli", "Hamza", "hamza@email.com");
        utilisateurRepo.ajouter(etudiant);
    }

    @Test
    public void testEmprunterLivreSucces() {
        assertDoesNotThrow(() -> service.emprunterLivre(1, 1));
        assertFalse(livreRepo.trouverParId(1).get().isDisponible());
    }

    @Test
    public void testEmprunterLivreDejaEmprunteLanceException() {
        assertDoesNotThrow(() -> service.emprunterLivre(1, 1));
        
        Exception exception = assertThrows(LivreIndisponibleException.class, () -> {
            service.emprunterLivre(1, 1);
        });

        assertEquals("Le livre est déjà emprunté.", exception.getMessage());
    }
}
package fr.library.repository;

import fr.library.model.Livre;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivreRepository implements IRepository<Livre> {
    
    private List<Livre> livres;

    public LivreRepository() {
        this.livres = new ArrayList<>();
    }

    @Override
    public void ajouter(Livre livre) {
        livres.add(livre);
    }

    @Override
    public void supprimer(int id) {
        livres.removeIf(l -> l.getId() == id);
    }

    @Override
    public void modifier(Livre livreModifie) {
        trouverParId(livreModifie.getId()).ifPresent(livre -> {
            livre.setTitre(livreModifie.getTitre());
            livre.setAuteur(livreModifie.getAuteur());
            livre.setIsbn(livreModifie.getIsbn());
            livre.setAnneePublication(livreModifie.getAnneePublication());
            livre.setGenre(livreModifie.getGenre());
            livre.setDisponible(livreModifie.isDisponible());
        });
    }

    @Override
    public Optional<Livre> trouverParId(int id) {
        return livres.stream()
                .filter(l -> l.getId() == id)
                .findFirst();
    }

    @Override
    public List<Livre> listerTout() {
        return new ArrayList<>(livres);
    }
}
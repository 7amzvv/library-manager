package fr.library.repository;

import fr.library.model.Emprunt;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpruntRepository implements IRepository<Emprunt> {

    private List<Emprunt> emprunts;

    public EmpruntRepository() {
        this.emprunts = new ArrayList<>();
    }

    @Override
    public void ajouter(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    @Override
    public void supprimer(int id) {
        emprunts.removeIf(e -> e.getId() == id);
    }

    @Override
    public void modifier(Emprunt empruntModifie) {
        trouverParId(empruntModifie.getId()).ifPresent(emprunt -> {
            emprunt.setDateRetourEffective(empruntModifie.getDateRetourEffective());
        });
    }

    @Override
    public Optional<Emprunt> trouverParId(int id) {
        return emprunts.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<Emprunt> listerTout() {
        return new ArrayList<>(emprunts);
    }
}
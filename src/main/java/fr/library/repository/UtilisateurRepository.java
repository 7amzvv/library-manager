package fr.library.repository;

import fr.library.model.Utilisateur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UtilisateurRepository implements IRepository<Utilisateur> {
    
    private Map<Integer, Utilisateur> utilisateurs;

    public UtilisateurRepository() {
        this.utilisateurs = new HashMap<>();
    }

    @Override
    public void ajouter(Utilisateur utilisateur) {
        utilisateurs.put(utilisateur.getId(), utilisateur);
    }

    @Override
    public void supprimer(int id) {
        utilisateurs.remove(id);
    }

    @Override
    public void modifier(Utilisateur utilisateurModifie) {
        if (utilisateurs.containsKey(utilisateurModifie.getId())) {
            utilisateurs.put(utilisateurModifie.getId(), utilisateurModifie);
        }
    }

    @Override
    public Optional<Utilisateur> trouverParId(int id) {
        return Optional.ofNullable(utilisateurs.get(id));
    }

    @Override
    public List<Utilisateur> listerTout() {
        return new ArrayList<>(utilisateurs.values());
    }
}
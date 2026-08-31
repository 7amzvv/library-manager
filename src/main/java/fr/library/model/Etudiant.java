package fr.library.model;

public class Etudiant extends Utilisateur {
    
    public Etudiant(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
    }

    @Override
    public String getRole() {
        return "Étudiant";
    }
}
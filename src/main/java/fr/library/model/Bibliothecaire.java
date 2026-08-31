package fr.library.model;

public class Bibliothecaire extends Utilisateur {
    
    public Bibliothecaire(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
    }

    @Override
    public String getRole() {
        return "Bibliothécaire";
    }
}
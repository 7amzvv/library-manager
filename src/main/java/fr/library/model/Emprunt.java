package fr.library.model;

import java.time.LocalDate;

public class Emprunt {
    private int id;
    private Livre livre;
    private Utilisateur utilisateur;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourEffective;

    public Emprunt(int id, Livre livre, Utilisateur utilisateur, LocalDate dateEmprunt, LocalDate dateRetourPrevue) {
        this.id = id;
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Livre getLivre() { return livre; }
    public void setLivre(Livre livre) { this.livre = livre; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public void setDateEmprunt(LocalDate dateEmprunt) { this.dateEmprunt = dateEmprunt; }
    public LocalDate getDateRetourPrevue() { return dateRetourPrevue; }
    public void setDateRetourPrevue(LocalDate dateRetourPrevue) { this.dateRetourPrevue = dateRetourPrevue; }
    public LocalDate getDateRetourEffective() { return dateRetourEffective; }
    public void setDateRetourEffective(LocalDate dateRetourEffective) { this.dateRetourEffective = dateRetourEffective; }

    public boolean isRetourne() {
        return dateRetourEffective != null;
    }

    @Override
    public String toString() {
        return "Emprunt #" + id + " : " + livre.getTitre() + " par " + utilisateur.getNom() + " (Retour prévu le : " + dateRetourPrevue + ")";
    }
}
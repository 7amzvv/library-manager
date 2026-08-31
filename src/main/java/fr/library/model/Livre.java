package fr.library.model;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String isbn;
    private int anneePublication;
    private Genre genre;
    private boolean disponible;

    public Livre(int id, String titre, String auteur, String isbn, int anneePublication, Genre genre) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.anneePublication = anneePublication;
        this.genre = genre;
        this.disponible = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getAnneePublication() { return anneePublication; }
    public void setAnneePublication(int anneePublication) { this.anneePublication = anneePublication; }
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return id + " - " + titre + " (" + auteur + ", " + anneePublication + ") [" + genre + "] - " + (disponible ? "Disponible" : "Emprunté");
    }
}
package fr.library.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    void ajouter(T entity);
    void supprimer(int id);
    void modifier(T entity);
    Optional<T> trouverParId(int id);
    List<T> listerTout();
}
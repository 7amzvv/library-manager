# Library Manager 📚

## Présentation
Library Manager est une application console de gestion de bibliothèque développée en Java. Ce projet a été conçu pour mettre en pratique les concepts fondamentaux de la Programmation Orientée Objet (POO) ainsi que l'architecture logicielle standard (séparation des responsabilités).

## Objectifs Pédagogiques
- Appliquer les concepts avancés de la POO : Encapsulation, Héritage, Polymorphisme, Abstraction.
- Manipuler efficacement les Collections Java (`ArrayList`, `HashMap`).
- Gérer les Exceptions personnalisées de manière propre.
- Mettre en place des tests unitaires automatisés.
- Utiliser Maven pour la gestion du cycle de vie du projet et des dépendances.

## Fonctionnalités Principales
- **Gestion des livres :** Ajout, affichage, et vérification de la disponibilité.
- **Gestion des utilisateurs :** Ajout d'étudiants et de bibliothécaires (via Héritage).
- **Système d'emprunt :** 
  - Emprunt d'un livre avec génération des dates de retour.
  - Retour de livre.
  - Prévention des doubles emprunts via un système d'exceptions métier.
- **Recherche et Tri :** Recherche par titre via l'API Stream et tri par année de publication (Comparator).

## Technologies Utilisées
- **Langage :** Java 17
- **Gestionnaire de dépendances :** Maven
- **Tests :** JUnit 5
- **Contrôle de version :** Git & GitHub

## Architecture du Projet
Le projet suit un découpage en packages pour séparer clairement les responsabilités :
- `model/` : Entités métiers (`Livre`, `Utilisateur`, `Emprunt`, Enum `Genre`).
- `repository/` : Stockage des données en mémoire implémentant une interface générique `IRepository`.
- `service/` : Logique métier (règles d'emprunt, recherche avec Streams).
- `exception/` : Erreurs personnalisées (`LivreIndisponibleException`, etc.).
- `ui/` : Interface utilisateur interactive en ligne de commande.

## Installation et Exécution

**1. Cloner le repository :**
```bash
git clone [https://github.com/7amzvv/library-manager.git](https://github.com/7amzvv/library-manager.git)
cd library-manager
package Bibliotheque.mvp.model;

import Bibliotheque.metier.Auteur;

import java.util.List;

public interface DAOAuteur{
        Auteur addAuteur(Auteur aut);

        boolean removeAuteur(Auteur aut);
        Auteur updateAuteur(Auteur aut);

        Auteur readAuteur(String nom, String prenom, String natio);

        List<Auteur> getAuteurs();
    }


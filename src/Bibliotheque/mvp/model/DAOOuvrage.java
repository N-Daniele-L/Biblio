package Bibliotheque.mvp.model;

import Bibliotheque.metier.Ouvrage;

import java.util.List;

public interface DAOOuvrage {
    Ouvrage addOuvrage(Ouvrage ouv);

    boolean removeOuvrage(Ouvrage ouv);
    Ouvrage updateOuvrage(Ouvrage ouv);

    Ouvrage readOuvrage(String titre);

    List<Ouvrage> getOuvrages();
}
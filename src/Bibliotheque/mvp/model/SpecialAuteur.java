package Bibliotheque.mvp.model;

import Bibliotheque.metier.*;

import java.util.List;

public interface SpecialAuteur {
    public List<Ouvrage> listeAllOuvrage(Auteur a);

    public List<Ouvrage> listeAllOuvrageByType(Auteur a, TypeOuvrage to);

    public List<Livre> listeAllOuvrageByLivre(Auteur a, TypeLivre tl);

    public List<Ouvrage> listeAllOuvrageByGenre(Auteur a, String genre);

}


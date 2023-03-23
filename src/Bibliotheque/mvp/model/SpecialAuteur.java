package Bibliotheque.mvp.model;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialAuteur {
    public List<Ouvrage> listeAllOuvrage(Auteur a);

    public List<Ouvrage> listeAllOuvrageByType(Auteur a);

    public List<Ouvrage> listeAllOuvrageByLivre(Auteur a);

    public List<Ouvrage> listeAllOuvrageByGenre(Auteur a);

}

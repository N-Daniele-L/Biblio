package Bibliotheque.mvp.model;

import Bibliotheque.metier.*;

import java.util.List;

public interface SpecialAuteur {
public List<Ouvrage>  listerOuvrages(Auteur a);
public List<Livre> listerLivre(Auteur a,TypeLivre tl);

public List<Ouvrage> listerOuvrages(Auteur a, String genre);
}

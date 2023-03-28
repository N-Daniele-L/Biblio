package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialOuvrage {
    List<Exemplaire> listerExemplaires(Ouvrage ouvrage);
    List<Exemplaire> listerExemplairesLocation(Ouvrage ouvrage);
}

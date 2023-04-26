package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.Rayon;

import java.util.List;

public interface SpecialRayon {
    List<Exemplaire> listerExemplaires(Rayon rayon);
}

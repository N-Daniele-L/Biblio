package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;

import java.util.List;

public interface SpecialRayon {
   public List<Exemplaire> listerExemplaires(Rayon r);
}

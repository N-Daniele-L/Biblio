package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;

import java.util.List;
public interface SpecialOuvrage {
   public List<Exemplaire> listerExemplaire(Ouvrage o);
    public List<Exemplaire> listerExemplaire(Ouvrage o,boolean enLocation);

    public double amendeRetard(Ouvrage o,int nj);

}
package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;

import java.util.List;

public interface SpecialLecteur {
    public List<Exemplaire> exemplairesEnLocation(Lecteur l);
    public List<Exemplaire> exemplairesLoues(Lecteur l);

}

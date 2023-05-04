package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.Rayon;

import java.util.List;

public class OuvrageModel extends AbstractModel<Ouvrage> implements SpecialOuvrage {
    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o) {
        return o.listerExemplaires();
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation) {
        return o.listerExemplaires(enLocation);
    }

    @Override
    public double amendeRetard(Ouvrage o, int nj) {
        return o.amendeRetard(nj);
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return null;
    }
}

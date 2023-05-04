package Bibliotheque.mvp.model;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Location;
import Bibliotheque.metier.Rayon;

import java.util.List;

public class LocationModel extends AbstractModel<Location> implements Speciallocation{
    @Override
    public double calculerAmende(Location l) {
        return l.calculerAmende();
    }

    @Override
    public void enregistrerRetour(Location l) {
        l.enregistrerRetour();
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return null;
    }
}

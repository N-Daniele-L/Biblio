package Bibliotheque.mvp.model;

import Bibliotheque.metier.Location;

public class LocationModel extends AbstractModel<Location> implements Speciallocation{

    @Override
    public double calculerAmende(Location l) {
        return 0;
    }

    @Override
    public void enregistrerRetour(Location l) {

    }
}

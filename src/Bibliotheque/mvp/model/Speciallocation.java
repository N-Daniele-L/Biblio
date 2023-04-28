package Bibliotheque.mvp.model;

import Bibliotheque.metier.*;

public interface Speciallocation {
 public double calculerAmende(Location l);
 public void enregistrerRetour(Location l);
}

package Bibliotheque.mvp.view;

import Bibliotheque.metier.Ouvrage;

public interface SpecialOuvrageViewConsole {
    void enLocation(Ouvrage o, boolean enLocation);

    void exemplaires(Ouvrage o);
}

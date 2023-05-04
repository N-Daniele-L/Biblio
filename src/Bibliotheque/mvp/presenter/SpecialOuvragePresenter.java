package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Ouvrage;

public interface SpecialOuvragePresenter {
    void setAuteurPresenter(Presenter<Auteur> auteurPresenter);

    Auteur choixAuteur();

    void listerExemplaire(Ouvrage o);

    void listerExemplaire(Ouvrage o, boolean enLocation);
}

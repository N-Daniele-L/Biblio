package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.metier.Location;

public interface SpecialLocationPresenter {
    void setExemplairePresenter(Presenter<Exemplaire> exemplairePresenter);

    void setLecteurPresenter(Presenter<Lecteur> lecteurPresenter);

    Exemplaire choixExemplaire();

    Lecteur choixLecteur();

    void calculerAmende(Location l);

    void enregistrerRetour(Location l);
}

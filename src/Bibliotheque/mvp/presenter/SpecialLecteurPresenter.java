package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Lecteur;

public interface SpecialLecteurPresenter {
    void exemplairesEnLocation(Lecteur l);

    void exemplairesLoues(Lecteur l);

    void lecParMail(String mail);
}

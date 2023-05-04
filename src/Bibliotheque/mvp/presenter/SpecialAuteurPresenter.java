package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.TypeLivre;

public interface SpecialAuteurPresenter {
    void listerOuvrages(Auteur a);

    void listerLivre(Auteur a, TypeLivre tl);

    void listerOuvrages(Auteur a, String genre);
}

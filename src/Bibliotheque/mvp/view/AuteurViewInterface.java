package Bibliotheque.mvp.view;

import Bibliotheque.metier.Auteur;

import Bibliotheque.metier.Ouvrage;
import Bibliotheque.mvp.presenter.AuteurPresenter;

import java.util.List;

public interface AuteurViewInterface {
    public void setPresenter(AuteurPresenter presenter);

    public void setListDatas(List<Auteur> auteurs);

    public void affMsg(String msg);
    void affList(List<Ouvrage> ouvr);
}

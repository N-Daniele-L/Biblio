package Bibliotheque.mvp.view;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.mvp.presenter.OuvragePresenter;

import java.util.List;

public interface OuvrageViewInterface {
    public void setPresenter(OuvragePresenter presenter);

    public void setListDatas(List<Ouvrage> ouvrages);

    public void affMsg(String msg);

    public void affList(List<Exemplaire> ex);
}

package Bibliotheque.mvp.view;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.presenter.RayonPresenter;

import java.util.List;

public interface RayonViewInterface {
    public void setPresenter(RayonPresenter presenter);

    public void setListDatas(List<Rayon> rayons);

    public void affMsg(String msg);

    public void affList(List<Exemplaire> ex);
}

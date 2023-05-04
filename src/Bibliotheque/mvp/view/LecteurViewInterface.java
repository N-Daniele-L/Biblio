package Bibliotheque.mvp.view;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.mvp.presenter.LecteurPresenterV1;

import java.util.List;

public interface LecteurViewInterface {
    public void setPresenter(LecteurPresenterV1 presenter);

    public void setListDatas(List<Lecteur> lecteurs);

    public void affMsg(String msg);


    void affList(List<Exemplaire> lex);

    Lecteur selectionner(List<Lecteur> all);
}

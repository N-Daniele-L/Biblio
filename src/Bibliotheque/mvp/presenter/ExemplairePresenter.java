package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.view.ViewInterface;

public class ExemplairePresenter extends Presenter<Exemplaire> {


    public ExemplairePresenter(DAOGenerique<Exemplaire> model, ViewInterface<Exemplaire> view) {
        super(model,view);
    }


}

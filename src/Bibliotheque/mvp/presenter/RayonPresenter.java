package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.model.SpecialRayon;
import Bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class RayonPresenter extends Presenter<Rayon> {
    public RayonPresenter(DAOGenerique<Rayon> model, ViewInterface<Rayon> view) {
        super(model, view);
    }

    public void listerExemplaires(Rayon rayon) {
        List<Exemplaire> ex = ((SpecialRayon)model).listerExemplaires(rayon);
        if(ex==null || ex.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ex);
    }
}

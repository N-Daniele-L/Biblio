package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.model.DAO;
import Bibliotheque.mvp.model.SpecialRayon;
import Bibliotheque.mvp.view.ViewInterface;


public class RayonPresenter extends Presenter<Rayon> implements SpecialRayonPresenter {
    public RayonPresenter(DAO<Rayon> model, ViewInterface<Rayon> view) {
        super(model, view);
    }

    @Override
    public void listerExemplaires(Rayon r){
        view.affList(((SpecialRayon)model).listerExemplaires(r));
    }
}
package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Location;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.view.ViewInterface;

public class LocationPresenter extends Presenter<Location> {


    public LocationPresenter(DAOGenerique<Location> model, ViewInterface<Location> view) {
        super(model,view);
    }


}

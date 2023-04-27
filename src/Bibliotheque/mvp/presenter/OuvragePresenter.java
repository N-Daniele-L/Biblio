package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.model.SpecialOuvrage;
import Bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class OuvragePresenter extends Presenter<Ouvrage> {


    public OuvragePresenter(DAOGenerique<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model,view);
    }
    public void listerExemplaires(Ouvrage ouvrage) {
        List<Exemplaire> ex = ((SpecialOuvrage)model).listerExemplaires(ouvrage);
        if(ex==null || ex.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ex);
    }

    public void listerExemplairesLocation(Ouvrage ouvrage) {
        List<Exemplaire> ex = ((SpecialOuvrage)model).listerExemplairesLocation(ouvrage);
        if(ex==null || ex.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ex);    }

}

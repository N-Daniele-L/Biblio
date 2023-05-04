package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.metier.Location;
import Bibliotheque.mvp.model.DAO;
import Bibliotheque.mvp.model.Speciallocation;
import Bibliotheque.mvp.view.ViewInterface;

public class LocationPresenter extends Presenter<Location> implements SpecialLocationPresenter {
    private Presenter<Exemplaire> exemplairePresenter;
    private Presenter<Lecteur> lecteurPresenter;


    @Override
    public void setExemplairePresenter(Presenter<Exemplaire> exemplairePresenter) {
        this.exemplairePresenter = exemplairePresenter;
    }

    @Override
    public void setLecteurPresenter(Presenter<Lecteur> lecteurPresenter) {
        this.lecteurPresenter = lecteurPresenter;
    }


    @Override
    public Exemplaire choixExemplaire(){
        return exemplairePresenter.selection();
    }

    @Override
    public Lecteur choixLecteur(){
        return lecteurPresenter.selection();
    }
    public LocationPresenter(DAO<Location> model, ViewInterface<Location> view) {
        super(model,view);
    }

    @Override
    public void  calculerAmende(Location l){
        view.affMsg("amende = "+((Speciallocation)model).calculerAmende(l));
    }
    @Override
    public void enregistrerRetour(Location l){
        ((Speciallocation)model).enregistrerRetour(l);
        view.affMsg("retour enregistré");
    }

}

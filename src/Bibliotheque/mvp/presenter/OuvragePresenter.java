package Bibliotheque.mvp.presenter;


import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.mvp.model.DAO;
import Bibliotheque.mvp.model.SpecialOuvrage;
import Bibliotheque.mvp.view.ViewInterface;


public class OuvragePresenter extends Presenter<Ouvrage> implements SpecialOuvragePresenter{

    private Presenter<Auteur> auteurPresenter;
    @Override
    public void setAuteurPresenter(Presenter<Auteur> auteurPresenter) {
        this.auteurPresenter = auteurPresenter;
    }

    @Override
    public Auteur choixAuteur(){
       return  auteurPresenter.selection();
    }

    public OuvragePresenter(DAO<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model,view);
    }

    @Override
    public void  listerExemplaire(Ouvrage o){
        view.affList(((SpecialOuvrage)model).listerExemplaire(o));
    }
    @Override
    public void listerExemplaire(Ouvrage o, boolean enLocation){
        view.affList(((SpecialOuvrage)model).listerExemplaire(o,enLocation));
    }
}

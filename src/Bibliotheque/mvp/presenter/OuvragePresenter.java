package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.model.DAOOuvrage;
import Bibliotheque.mvp.model.SpecialAuteur;
import Bibliotheque.mvp.model.SpecialOuvrage;
import Bibliotheque.mvp.view.OuvrageViewConsole;
import Bibliotheque.mvp.view.OuvrageViewInterface;

import java.util.List;

public class OuvragePresenter {

    private DAOOuvrage model;
    private OuvrageViewInterface view;

    OuvragePresenter(DAOOuvrage model, OuvrageViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListDatas(getAll());
    }
    public List<Ouvrage> getAll(){
        return model.getOuvrages();
    }
    public void addOuvrage(Ouvrage ouvrage) {
        Ouvrage ouvr = model.addOuvrage(ouvrage);
        if(ouvr!=null) view.affMsg("création de :"+ouvr);
        else view.affMsg("erreur de création");
        List<Ouvrage> ouvrages = model.getOuvrages();
    }
    public void removeOuvrage(Ouvrage ouvrage) {
        boolean ok = model.removeOuvrage(ouvrage);
        if(ok) view.affMsg("lecteur effacé");
        else view.affMsg("lecteur non effacé");
        List<Ouvrage> ouvrages = model.getOuvrages();
    }
    public void update(Ouvrage ouvrage) {
        Ouvrage o  =model.updateOuvrage(ouvrage);
        if(o==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+o);
    }

    public void search(String titre) {
        Ouvrage o = model.readOuvrage(titre);
        if(o==null) view.affMsg("recherche infructueuse");
        else view.affMsg(o.toString());
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

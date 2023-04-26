package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Rayon;
import Bibliotheque.mvp.model.DAORayon;
import Bibliotheque.mvp.model.SpecialRayon;
import Bibliotheque.mvp.view.RayonViewInterface;

import java.util.List;

public class RayonPresenter {
    private DAORayon model;
    private RayonViewInterface view;

    public RayonPresenter(DAORayon model, RayonViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListDatas(getAll());
    }
    public List<Rayon> getAll(){
        return model.getRayons();
    }
    public void addRayon(Rayon rayon) {
        Rayon ray = model.addRayon(rayon);
        if(ray!=null) view.affMsg("création de : "+ray);
        else view.affMsg("erreur de création");
        List<Rayon> rayons = model.getRayons();
    }
    public void removeRayon(Rayon rayon) {
        boolean ok = model.removeRayon (rayon);
        if(ok) view.affMsg("rayon effacé");
        else view.affMsg("rayon non effacé");
        List<Rayon> rayons = model.getRayons();
    }
    public void update(Rayon rayon) {
        Rayon r  =model.updateRayon(rayon);
        if(r==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+r);
    }

    public void search(String idRay) {
        Rayon o = model.readRayon(idRay);
        if(o==null) view.affMsg("recherche infructueuse");
        else view.affMsg(o.toString());
    }
    public void listerExemplaires(Rayon rayon) {
        List<Exemplaire> ex = ((SpecialRayon)model).listerExemplaires(rayon);
        if(ex==null || ex.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ex);
    }
}

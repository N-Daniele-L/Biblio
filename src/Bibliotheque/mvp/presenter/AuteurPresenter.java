package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Auteur;
import Bibliotheque.metier.Ouvrage;
import Bibliotheque.metier.TypeOuvrage;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.model.SpecialAuteur;
import Bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class AuteurPresenter extends Presenter<Auteur> {


    public AuteurPresenter(DAOGenerique<Auteur> model, ViewInterface<Auteur> view) {
        super(model, view);
    }
    public void listeAllOuvrage(Auteur a) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrage(a);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }

    /*public void listeAllOuvrageByType(Auteur a) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrageByType(a);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }

    public void listeAllOuvrageByLivre(Auteur a) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrageByLivre(a);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);

    }

    public void listeAllOuvrageByGenre(Auteur a) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrageByGenre(a);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }*/
}

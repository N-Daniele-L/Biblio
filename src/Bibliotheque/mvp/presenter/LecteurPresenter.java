package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.mvp.model.DAOGenerique;
import Bibliotheque.mvp.model.SpecialLecteur;
import Bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class LecteurPresenter extends Presenter<Lecteur> {


    public LecteurPresenter(DAOGenerique<Lecteur> model, ViewInterface<Lecteur> view) {
        super(model,view);
    }


    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}

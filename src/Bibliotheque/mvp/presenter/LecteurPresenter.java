package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.Exemplaire;
import Bibliotheque.metier.Lecteur;
import Bibliotheque.mvp.model.DAO;
import Bibliotheque.mvp.model.SpecialLecteur;
import Bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class LecteurPresenter extends Presenter<Lecteur> implements SpecialLecteurPresenter {


    public LecteurPresenter(DAO<Lecteur> model, ViewInterface<Lecteur> view) {
        super(model,view);
    }


    @Override
    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    @Override
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }

    @Override
    public void lecParMail(String mail) {
        Lecteur l = ((SpecialLecteur)model).lecParMail(mail);
        if(l==null) view.affMsg("aucun lecteur pour ce mail");
        else view.affMsg("lecteur trouvé :" +l);
    }
}

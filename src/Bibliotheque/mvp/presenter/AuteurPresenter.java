package Bibliotheque.mvp.presenter;

import Bibliotheque.metier.*;
import Bibliotheque.mvp.model.DAOAuteur;
import Bibliotheque.mvp.model.SpecialAuteur;
import Bibliotheque.mvp.view.AuteurViewInterface;

import java.util.List;

public class AuteurPresenter {
    private DAOAuteur model;
    private AuteurViewInterface view;

    public AuteurPresenter(DAOAuteur model, AuteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Auteur> getAll(){
        return model.getAuteurs();
    }

    public void addLecteur(Auteur auteur) {
        Auteur aut = model.addAuteur(auteur);
        if(aut!=null) view.affMsg("création de :"+aut);
        else view.affMsg("erreur de création");
        //List<Auteur> a = model.getAuteurs();
        // view.setListDatas(lecteurs); //désactivé pour éviter appels imbriqués
    }


    public void removeLecteur(Auteur auteur) {
        boolean ok = model.removeAuteur(auteur);
        if(ok) view.affMsg("lecteur effacé");
        else view.affMsg("lecteur non effacé");
        //List<Auteur> a = model.getAuteurs();
        //view.setListDatas(lecteurs); //désactivé pour éviter appels imbriqués
    }
    public void update(Auteur auteur) {
        Auteur l  =model.updateAuteur(auteur);
        if(l==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+l);
        //view.setListDatas(model.getClients());//désactivé pour éviter appels imbriqués
    }

    public void search(String nom, String prenom, String natio) {
        Auteur a = model.readAuteur(nom,prenom,natio);
        if(a==null) view.affMsg("recherche infructueuse");
        else view.affMsg(a.toString());
    }
    public void listeAllOuvrage(Auteur a) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrage(a);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }

    public void listeAllOuvrageByType(Auteur a, TypeOuvrage to) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrageByType(a, to);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }

    public void listeAllOuvrageByLivre(Auteur a, TypeLivre tl) {
        List<Livre> livr = ((SpecialAuteur)model).listeAllOuvrageByLivre(a, tl);
        if(livr==null || livr.isEmpty()) view.affMsg("aucun livre trouvé");
        else view.afficheList(livr);

    }

    public void listeAllOuvrageByGenre(Auteur a, String genre) {
        List<Ouvrage> ouvr = ((SpecialAuteur)model).listeAllOuvrageByGenre(a,genre);
        if(ouvr==null || ouvr.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(ouvr);
    }
}
